package com.cain.bos.dao;

import com.cain.bos.domain.User;

public interface IUserDao {

	User findUserByUsernameAndPassword(String username, String password);

	void executeUpdate(String string, Object... object);

}
