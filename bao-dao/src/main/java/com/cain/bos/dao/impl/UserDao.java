package com.cain.bos.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.cain.bos.dao.IUserDao;
import com.cain.bos.domain.User;

@Repository
public class UserDao extends BaseDaoImpl<User> implements IUserDao{

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		String hql = "FROM User u where u.username =? and u.password=?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username,password);
		if(list!= null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void executeUpdate(String string, Object... object) {
		// TODO Auto-generated method stub
		Session currentSession = this.getSessionFactory().getCurrentSession();
		Query namedQuery = currentSession.getNamedQuery(string);
		int i = 0;
		for (Object o:object) {
			namedQuery.setParameter(i++, o);
		}
		namedQuery.executeUpdate();
	}

}
