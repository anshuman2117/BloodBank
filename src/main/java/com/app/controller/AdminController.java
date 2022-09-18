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
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.UserDTO;
import com.app.entities.BloodDonation;
import com.app.entities.BloodInventory;
import com.app.entities.IdentityProof;
import com.app.entities.Status;
import com.app.entities.User;
import com.app.service.IBloodDonationService;
import com.app.service.IBloodInventoryService;
import com.app.service.IIdentityProofService;
import com.app.service.IUserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
// dep:  for  user service i/f
	@Autowired
	private IUserService userService;
//   dep:  identity proof service i/f
	@Autowired
	private IIdentityProofService idproofService;
//	dep: blood donation service i/f
	@Autowired
	private IBloodDonationService donationService;
//    dep: blood inventory service i/f
	@Autowired
	private IBloodInventoryService inventoryService;

	// Admin will create an user with verified status
	@PostMapping("/add_donor_user")
	public ResponseEntity<User> addUser(@RequestBody UserDTO userdto) {
		System.out.println("---user dto---" + userdto);
		return new ResponseEntity<>(userService.addUserByAdmin(userdto), HttpStatus.CREATED);
	}

	@GetMapping("/pendingIdStatus")
	public ResponseEntity<?> getPendingIdStatus() {
		return new ResponseEntity<>(idproofService.listPendingStatus(), HttpStatus.FOUND);
	}

	@PutMapping("/updateIdVerification/{id}")
	public ResponseEntity<?> updateIdVerificationStatus(@PathVariable Long id,
			@RequestParam String status /* @RequestBody IdentityProof id */ ) {
		return ResponseEntity.ok(idproofService.updateIdStatus(Status.valueOf(status), id));
	}

	@GetMapping("/getAllDonation")
	public ResponseEntity<List<BloodDonation>> getAllDonation() {
		List<BloodDonation> donation = donationService.getAllDonation();
		return new ResponseEntity<>(donation, HttpStatus.OK);
	}

	@PostMapping("/create_donation")
	public ResponseEntity<?> createBloodDonation(@RequestBody BloodDonation blood) {

		return new ResponseEntity<>(donationService.createBloodDonation(blood), HttpStatus.CREATED);
	}

	// add blood in blood inventory
	@PutMapping("/addblood")
	public ResponseEntity<?> addBloodStock(@RequestBody BloodInventory inventory) {

		inventoryService.addBloodInventory(inventory.getBagQuantity(), inventory.getBagSize(),
				inventory.getBloodGroup());

		return new ResponseEntity<>("stock updated", HttpStatus.CREATED);
	}

//	{future scope}
	// get blood donation details by sample id
//	@GetMapping("/getby_sampleId/{sampleId}")
//	public ResponseEntity<?> getDonationBySampleId(@PathVariable String sampleId){
//		
//		
//		return ResponseEntity.ok(donationService.fetchBySampleId(sampleId));
//	}

	// image storing of events method
//	@PostMapping("/{id}/event_image")
//	public  ResponseEntity<User> uploadImage(@PathVariable Long id,@RequestParam MultipartFile imageFile ){
//	
//		return new  ResponseEntity<>(imageHandlingService.storeImage(id, imageFile),HttpStatus.CREATED);
//	}

}
