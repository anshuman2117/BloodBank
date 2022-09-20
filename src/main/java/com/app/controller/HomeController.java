package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserLogInDTO;
import com.app.entities.User;
import com.app.service.EventService.IEventService;
import com.app.service.UserService.IUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/bloodbank")
@Slf4j
public class HomeController {
	
	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private IEventService eventService;
	
	
	
	
	
	public HomeController() {
		System.out.println("in ctor of " + getClass());
	}

	@GetMapping("/")
	public ResponseEntity<?> showHomePage() {
		log.info("in home page  of home controller ");
		return new ResponseEntity<>(eventService.listUpcomingEvents(),HttpStatus.CREATED);
	}
	
	@GetMapping(value="/event/{id}/image",produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE})
	public ResponseEntity<?> restoreImage(@PathVariable Long id){
		log.info("getting req. for event image download  ");
		
		byte[] restoreImage = eventService.restoreImage(id);
		return new ResponseEntity<>(restoreImage,HttpStatus.OK);
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