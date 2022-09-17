package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.AppointmentDTO;
import com.app.entities.Appointment;
import com.app.entities.Status;

public interface IAppointmentService {

//	to get all the scheduled appointments
	public List<Appointment> getAllAppointment();

//	to get the appointment status
	public List<AppointmentDTO> pendingAppointments();
	
//	to save/persist the appointments
	 Appointment saveAppointment(Appointment appointment);

//	to approve the  appointments
	public int updateAppointmentsStatus(String status, Appointment appointment);
	
    Appointment appointmentById(Long id);
}
