package com.app.service.AppointmentService;

import java.util.List;
import java.util.Optional;

import com.app.dto.Appointment2;
import com.app.dto.AppointmentDTO;
import com.app.entities.Appointment;
import com.app.entities.Patient;
import com.app.entities.Status;

public interface IAppointmentService {

//	to get all the scheduled appointments
	public List<AppointmentDTO> getAllAppointment();

//	to get the appointment status
	public List<AppointmentDTO> pendingAppointments();
	
//	to save/persist the appointments
//	 Appointment saveAppointment(Appointment appointment);
	 
	 Appointment saveAppointment(Long userid,Appointment appointment,Patient patient);

//	to approve the  appointments
	public boolean updateAppointmentsStatus(String status, Appointment appointment);
	
//    Appointment appointmentById(Long id);

	public List<AppointmentDTO> getAppointmentByuserId(Long id);
}
