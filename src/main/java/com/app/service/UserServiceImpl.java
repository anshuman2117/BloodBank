package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.IUserDao;
import com.app.entities.User;

public class UserServiceImpl implements IUserService {

	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public List<User> getAllUsers() {
		
		return userDao.findAll();
	}

}
