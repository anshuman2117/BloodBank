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

import com.app.dto.Appointment2;
import com.app.dto.AppointmentDTO;
import com.app.entities.Appointment;
import com.app.service.AppointmentService.IAppointmentService;


@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

	@Autowired
	private IAppointmentService appointmentService ;
//	@Autowired
//	private IBloodInventoryService bloodInventoryService;
	
	
	@PostMapping("/createAppointment")
	public ResponseEntity<?> createNewAppointment(@RequestBody Appointment2 appointment){
		
		return new ResponseEntity<>(appointmentService.saveAppointment(appointment.getUserId(),appointment.getAppointment(),appointment.getPatient()),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getUserAppointment/{id}")
	public ResponseEntity<?> getUserAppointment(@PathVariable Long id,@RequestBody AppointmentDTO appointmentDTO){
		List<AppointmentDTO> allAppointment=appointmentService.getAppointmentByuserId(id);
		
		return new ResponseEntity<>(allAppointment,HttpStatus.OK) ;
//		return new ResponseEntity<>("no appointments",HttpStatus.OK) ;
	}
	
	
//	@GetMapping
//	public ResponseEntity<?> listAllAppointments(){
//		List<Appointment> allAppointment = appointmentService.getAllAppointment();
//		if(!allAppointment.isEmpty())
//		return new ResponseEntity<>(allAppointment,HttpStatus.OK) ;
//		return new ResponseEntity<>("no appointments",HttpStatus.OK) ;
//		
//	}
	
	// list of pending appointments   used by admin
	
//	@GetMapping("/pending")
//	public ResponseEntity<?> listPendingAppointments(){
//		List<AppointmentDTO> allAppointment = appointmentService.pendingAppointments();
//		if(!allAppointment.isEmpty())
//		return new ResponseEntity<>(allAppointment,HttpStatus.OK) ;
//		return new ResponseEntity<>("no appointments",HttpStatus.OK) ;
//		
//	}
	
//	// controller to modify the status of the appointments
//	
//	@PutMapping("/update")
//	public ResponseEntity<?> resolvePendingSts(@RequestParam String status,@RequestBody Appointment appointment) {
//		System.out.println("status:-> "+status+" appointment-> "+appointment.toString());
//		appointmentService.updateAppointmentsStatus(status, appointment);
//		return new ResponseEntity<>(appointmentService.appointmentById(appointment.getId()),HttpStatus.ACCEPTED);
//	}
	
	
	
	// controller to persist the   appointment and is sub - related  method to be written here
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
