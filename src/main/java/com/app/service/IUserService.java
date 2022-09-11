package com.app.service;

import java.util.List;

import com.app.entities.User;

public interface IUserService {
	
	  public List<User> getAllUsers();

	  public User getUser(Long id);
	  
	  public User addUser(User user);
	  	  
	  public User updateUser(User user);
	  
	  public String deleteUser(Long id);
}
