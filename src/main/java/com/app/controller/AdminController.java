package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private IUserService userService;
	
	@PostMapping("/add_user")
	public ResponseEntity<User> addUser(@RequestBody User user){
		return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
	}
	
	//admin will verify the status of identity proof
	
	
	
	// suggestion   we should remove the verification status column from identity proof
	// in large  application base there is no one to verify the id proof it is taken granted aadhar/ voter id 
	// pan card have already verified the person
	// 
}
