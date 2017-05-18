package com.cain.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cain.bos.dao.IUserDao;
import com.cain.bos.domain.User;
import com.cain.bos.service.IUserService;
import com.cain.bos.utils.MD5Utils;

@Service
@Transactional
public class UserService implements IUserService{

	@Autowired
	private IUserDao iUserDao;
	
	@Override
	public User login(User model) {
		// TODO Auto-generated method stub
		String password = MD5Utils.md5(model.getPassword());
		return iUserDao.findUserByUsernameAndPassword(model.getUsername(),password);
	}

}
