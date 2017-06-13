package com.cain.bos.service;

import com.cain.bos.domain.Staff;
import com.cain.bos.utils.PageBean;

public interface IStaffService {

	public void add(Staff model);

	public void pageQuery(PageBean pageBean);

	public void deleteBatch(String ids);

	public Staff findById(String id);

	public void update(Staff staff);
	
}
