package com.app.dto;

import com.app.entities.Appointment;
import com.app.entities.Patient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Appointment2 {

	
	
	private Long userId;
	
	private Appointment appointment;
	
	private Patient patient;
	
}
