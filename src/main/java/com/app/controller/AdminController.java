package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDTO;
import com.app.entities.IdentityProof;
import com.app.entities.Status;
import com.app.entities.User;
import com.app.service.IIdentityProofService;
import com.app.service.IUserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IIdentityProofService idproofService;

	// admin will create an user with verified status
	@PostMapping("/add_donor_user")
	public ResponseEntity<User> addUser(@RequestBody UserDTO userdto) {
		System.out.println("---user dto---" + userdto);
		return new ResponseEntity<>(userService.addUserByAdmin(userdto), HttpStatus.CREATED);
	}

	@GetMapping("/pendingIdStatus")
	public ResponseEntity<?> getPendingIdStatus() {
//		System.out.println("getting req. for  showing all pending id sts");
//		List<IdentityProof> list = idproofService.listPendingStatus();
//		for (IdentityProof proof : list) {
//			System.out.println("id proof ------"+proof);
//		}
		return new ResponseEntity<>(idproofService.listPendingStatus(), HttpStatus.FOUND);
	}

	@PutMapping("/updateIdVerification/{id}")
	public ResponseEntity<?> updateIdVerificationStatus(@PathVariable Long id,
			@RequestParam String status /* @RequestBody IdentityProof id */ ) {
	return ResponseEntity.ok(idproofService.updateIdStatus(Status.valueOf(status), id));
	}

}
