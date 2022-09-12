package com.app.service;

import java.util.List;

import com.app.entities.Appointment;
import com.app.entities.Status;

public interface IAppointmentService {

//	to get all the scheduled appointments
	public List<Appointment> getAllAppointment();

//	to get the appointment status
	public String getAppointmentStatus(Long id);

//	to approve the  appointments
	public void updateStatus(Status status, Long id);

}
