package com.cain.bos.service;

import com.cain.bos.domain.User;

public interface IUserService {

	User login(User model);

	void editPassword(String id, String password);

}
