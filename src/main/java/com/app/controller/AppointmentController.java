package com.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Appointment;
import com.app.entities.BloodGroup;
import com.app.entities.Status;
import com.app.service.IAppointmentService;
import com.app.service.IBloodInventoryService;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

	@Autowired
	private IAppointmentService appointmentService ;
//	@Autowired
//	private IBloodInventoryService bloodInventoryService;
	
	@GetMapping
	public ResponseEntity<?> listAllAppointments(){
		List<Appointment> allAppointment = appointmentService.getAllAppointment();
		if(!allAppointment.isEmpty())
		return new ResponseEntity<>(allAppointment,HttpStatus.OK) ;
		return new ResponseEntity<>("no appointments",HttpStatus.OK) ;
		
	}
	@GetMapping("/pending")
	public ResponseEntity<?> listPendingAppointments(){
		List<Appointment> allAppointment = appointmentService.pendingAppointments();
		if(!allAppointment.isEmpty())
		return new ResponseEntity<>(allAppointment,HttpStatus.OK) ;
		return new ResponseEntity<>("no appointments",HttpStatus.OK) ;
		
	}
	
//	@PutMapping   // @RequestParam String status,
//	public ResponseEntity<?> updateAppointmentStatus( @RequestBody Appointment appointment) {//,int quantity, int bagSize, String bloodGroup
//		System.out.println("of user id->"+appointment.getUser());
//		//updating appointment status
//		 
//		Appointment ap1= appointmentService.updateStatus("APPROVED",appointment);
//		//updating blood inventory
////		bloodInventoryService.subBloodInventory(quantity, bagSize, bloodGroup);
//		return new ResponseEntity<>(ap1,HttpStatus.OK);
//	}
//	@DeleteMapping("/{apppointmentId}") // can use ANY name for a path var.
//	// @PathVariable => a binding between a path var to method arg.
//	public String deleteEmpDetails(@PathVariable @Range(min=1,max=100,message = "Invalid emp id!!!")  int empId) {
//		System.out.println("in del emp " + empId);
//		return empService.deleteEmpDetails(empId);
//	}
	
	
	
	
	
}
