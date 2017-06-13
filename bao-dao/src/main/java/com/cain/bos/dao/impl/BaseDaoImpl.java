package com.cain.bos.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;
import javax.lang.model.element.Parameterizable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.cain.bos.dao.IBaseDao;
import com.cain.bos.utils.PageBean;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {

	private Class<T> entityClass;
	
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	public BaseDaoImpl() {
		// TODO Auto-generated constructor stub
		ParameterizedType superclass =  (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = superclass.getActualTypeArguments();
		entityClass = (Class<T>) actualTypeArguments[0];
		
	}
	
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(entity);
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(entity);
	}

	@Override
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		String hql = "FROM" +entityClass.getSimpleName();
		return (List<T>) this.getHibernateTemplate().find(hql);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		int currentPage = pageBean.getCurrentPage();
		int pageSize = pageBean.getPageSize();
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		
		//指定hibernate框架发出sql的形式----》select count(*) from bc_staff;
		detachedCriteria.setProjection(Projections.rowCount());
		
		List<Long> findcount = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		
	 	pageBean.setTotal(findcount.get(0).intValue()); 
	 	
	 	//指定hibernate框架发出sql的形式----》select * from bc_staff;
		detachedCriteria.setProjection(null);
		
		int firstResult = (currentPage - 1) * pageSize;
		int maxResults = pageSize;
		List rows = this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
		pageBean.setRows(rows);
			
	}

	@Override
	public void executeUpdate(String queryName, Object... objects) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.getNamedQuery(queryName);
		int i = 0;
		for (Object object : objects) {
			//为HQL语句中的？赋值
			query.setParameter(i++, object);
		}
		//执行更新
		query.executeUpdate();
	}
	

}
