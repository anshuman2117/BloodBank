package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserLogInDTO;
import com.app.entities.User;
import com.app.service.UserService.IUserService;

@RestController
@RequestMapping("/api/bloodbank")
public class HomeController {
	
	@Autowired
	private IUserService iUserService;
	
	
	public HomeController() {
		System.out.println("in ctor of " + getClass());
	}

	@GetMapping("/")
	public ResponseEntity<?> showHomePage() {
		System.out.println("in home page");
		return new ResponseEntity<>( "  connection established !!!!",HttpStatus.CREATED);
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody UserLogInDTO dto) {
		System.out.println(" user_email "+dto.getEmail()+" pass "+dto.getPassword());
		User user=iUserService.getByEmailAndPassword(dto.getEmail(), dto.getPassword());
		if(user!=null)
		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
		else
		return new ResponseEntity<>("user_email or password invalid",HttpStatus.NOT_FOUND);
	
	}
}