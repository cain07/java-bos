package com.cain.bos.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cain.bos.action.base.BaseAction;
import com.cain.bos.domain.Staff;
import com.cain.bos.service.IStaffService;
import com.cain.bos.utils.PageBean;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff>{
	
	private int page;
	private int rows;
	
	private String ids;

	@Autowired
	private IStaffService staffService;
	
	public String add(){
		staffService.add(model);
		return LIST;
	}
	
	public String pageQuery() throws IOException{
		
		PageBean pageBean = new PageBean();
		
		pageBean.setCurrentPage(page);
		pageBean.setPageSize(rows);
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
		pageBean.setDetachedCriteria(detachedCriteria);
		
		staffService.pageQuery(pageBean);
		
		//使用json-lib将PageBean对象转为json，通过输出流写回页面中
		//JSONObject---将单一对象转为json
		//JSONArray----将数组或者集合对象转为json
		JsonConfig jsonConfig = new JsonConfig();
		//指定哪些属性不需要转json
		jsonConfig.setExcludes(new String[]{"currentPage","detachedCriteria","pageSize"});
		String json = JSONObject.fromObject(pageBean,jsonConfig).toString();
		
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(json);;
		return NONE;
	}
	
	public String deleteBatch(){
		staffService.deleteBatch(ids);
		return LIST;
	}

	public String edit(){
		Staff staff =  staffService.findById(model.getId());
		staff.setName(model.getName());
		staff.setTelephone(model.getTelephone());
		staff.setHaspda(model.getHaspda());
		staff.setDeltag(model.getDeltag());
		staff.setStandard(model.getStandard());
		staff.setStation(model.getStation());
		staffService.update(staff);
		return LIST;
	}
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
}
