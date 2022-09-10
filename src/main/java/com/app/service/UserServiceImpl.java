package com.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.IUserDao;
import com.app.entities.User;

@Service

public class UserServiceImpl implements IUserService {

	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
	@Override
	public User getUser(Long id) {
		return userDao.findById(id).get();
	}

	@Override
	public User addUser(User user) {
		userDao.save(user);
		return user;
	}
	
	@Override
	public User updateUser(User user) {
		return userDao.save(user);
	}
	
	
	@Override
	public void deleteUser(Long id) {
		User deleteuser=userDao.getById(id);
		userDao.delete(deleteuser);	
	}

}
