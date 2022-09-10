package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	//constructor of user controller
	public UserController() {
		System.out.println("in ctor of " + getClass());
	}
	
	//Get all users
	@GetMapping
	public List<User> getAllUsers(){
		return this.userService.getAllUsers();
	}
	
	//Get user by UserId
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getUser(id));
	}
	
	//Add user
	@PostMapping
	public User addUser(@RequestBody User user){
		return this.userService.addUser(user);
	}
	
	//Update user details
	@PutMapping
	public User updateUser(@RequestBody User user) {
		return this.userService.updateUser(user);
	}
	
	
	//delete user
	@DeleteMapping("/{userid}")
	public void deleteUser(@PathVariable Long userid) {
		userService.deleteUser(userid);
	}
	
}
