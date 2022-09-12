package com.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excpetions.ResourceNotFoundException;
import com.app.dao.IUserDao;
import com.app.entities.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
	@Override
	public User getUser(Long id) {
		return userDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid User id" + id));
	}

	@Override
	public User addUser(User user) {
		return userDao.save(user);
	}
	
	@Override
	public User updateUser(User user) {
		return userDao.save(user);
	}
	
	
	@Override
	public String deleteUser(Long id) {
		String message= "Deletion of User failed";
		if (userDao.existsById(id)) {
			userDao.deleteById(id);
			message= "User removed successfully with UserId : "+id;
		}
		return message;	
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userDao.findByEmailAndPassword(email, password);
		 
	}

}
