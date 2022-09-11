package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
		System.out.println("in constructor of " + getClass());
	}
	
	//Get all users
	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		List<User> users = userService.getAllUsers();
		if (users.isEmpty()) 
			return new ResponseEntity<>("user list is empty", HttpStatus.OK);
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	//Get user by UserId
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(userService.getUser(id));
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	//Add user
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user){
		return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
	}
	
	//Update user details
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUser(user),HttpStatus.OK);
	}
	
	
	//delete user
	@DeleteMapping("/{userid}")
	public ResponseEntity<?> deleteUser(@PathVariable Long userid) {
		try {
			return ResponseEntity.ok(userService.deleteUser(userid));
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}
