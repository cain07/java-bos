package com.cain.bos.dao;

import java.io.Serializable;
import java.util.List;

import com.cain.bos.utils.PageBean;

public interface IBaseDao<T> {

	public void save(T entity);
	public void delete(T entity);
	public void update(T entity);
	public T findById(Serializable id);
	public List<T> findAll();
	public void executeUpdate(String queryName,Object...objects);
	public void pageQuery(PageBean pageBean);
}
