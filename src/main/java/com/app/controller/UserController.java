package com.app.controller;

import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.UserDTO;
import com.app.entities.IdentityProof;
import com.app.entities.Status;
import com.app.entities.User;
import com.app.service.IIdentityProofService;
import com.app.service.IUserService;
import com.app.service.IdentityProofServiceImpl;
import com.app.service.ImageHandlingService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IIdentityProofService identityProofService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ImageHandlingService imageHandlingService;
	
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
			IdentityProof identityProofByUserId = identityProofService.getIdentityProofByUserId(id);
//			User userReturn = userService.getUser(id);
//			UserDTO user=modelMapper.map(userReturn, UserDTO.class);
//			IdentityProof identityProofByUserId = identityProofService.getIdentityProofByUserId(id);
//			user.setDocumentType(identityProofByUserId.getDocumentType());
//			user.setUniqueIdNumber(identityProofByUserId.getUniqueIdNumber());
//			user.setStatus(identityProofByUserId.getStatus());
			return ResponseEntity.ok(identityProofByUserId);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	//Add user
	@PostMapping("/register")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDto){
		
		UserDTO userDtoReturn=userService.addUser(userDto);                       // persisting user data
		   
		return new ResponseEntity<>(userDtoReturn, HttpStatus.CREATED);
	}
	
	//Update user details
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDTO identityProof1) {
		identityProof1.setId(id);
		User user=modelMapper.map(identityProof1, User.class);
		IdentityProof identityProof=modelMapper.map(identityProof1, IdentityProof.class);
		User updatedUser = userService.updateUser(id,user);
		identityProof.setUser(updatedUser);
		return new ResponseEntity<>(identityProofService.saveIdentityProof(id,identityProof),HttpStatus.CREATED);
	}
	
	
	//delete user
	@DeleteMapping("/{userid}")
	public ResponseEntity<?> deleteUser(@PathVariable Long userid) {
		try {
			identityProofService.deleteIdentityProof(userid);
			String string = userService.deleteUser(userid);
			return ResponseEntity.ok(string);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	// add a method to upload a image on server side
	@PostMapping("/{id}/image")
	public  ResponseEntity<User> uploadImage(@PathVariable Long id,@RequestParam MultipartFile imageFile ){
	
		return new  ResponseEntity<>(imageHandlingService.storeImage(id, imageFile),HttpStatus.CREATED);
	}
	
	
	// add req method to to download image for specific request
	
	@GetMapping(value="/{id}/image",produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE})
	public ResponseEntity<?> restoreImage(@PathVariable Long id){
		byte[] restoreImage = imageHandlingService.restoreImage(id);
		return new ResponseEntity<>(restoreImage,HttpStatus.OK);
	}
	
}
