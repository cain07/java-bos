package com.cain.bos.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cain.bos.dao.IStaffDao;
import com.cain.bos.domain.Staff;
import com.cain.bos.service.IStaffService;
import com.cain.bos.utils.PageBean;

@Service
@Transactional
public class StaffService implements IStaffService {

	@Autowired
	private IStaffDao staffDao;
	
	@Override
	public void add(Staff model) {
		// TODO Auto-generated method stub
		System.out.println(model.toString());
		staffDao.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		staffDao.pageQuery(pageBean);
	}

	/**
	 * 取派员批量删除
	 * 逻辑删除，将deltag改为1
	 */
	@Override
	public void deleteBatch(String ids) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(ids)){
			String[] split = ids.split(",");
			for(String id:split){
				staffDao.executeUpdate("staff.delete", id);;
			}
		}
	}

	@Override
	public Staff findById(String id) {
		// TODO Auto-generated method stub
		return staffDao.findById(id);
	}

	@Override
	public void update(Staff staff) {
		// TODO Auto-generated method stub
		staffDao.update(staff);
	}

}
