package com.app.service;

import java.util.List;

import com.app.entities.User;

public interface IUserService {
	// to get the list of all registered user
	public List<User> getAllUsers();

	// to get the user details by giving email and password ->for login
	public User getByEmailAndPassword(String email, String password);

//      to get the user  details of a particular user by id
	public User getUser(Long id);

//	  to add a new user
	public User addUser(User user);

//	  	  to update / modify  the user detail
	public User updateUser(User user);

//	  to delete the user
	public String deleteUser(Long id);
}
