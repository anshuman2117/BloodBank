package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAppointmentDao;
import com.app.entities.Appointment;
import com.app.entities.Status;

@Service
@Transactional
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	private IAppointmentDao appointmentDao;

	@Override
	public List<Appointment> getAllAppointment() {

		return appointmentDao.findAll();
	}
	
	//-------------------------------------------------------------------check it once------------------
   // doubt in this part
	@Override
//	public void updateStatus(String status,Long id) {
//		if(status.toString().equals("REJECTED")) {
//			appointmentDao.deleteById(id);
//		}
//		else {
//		appointmentDao.updateAppointmentStatus(status,id);
//		}
//	}
	public Appointment updateStatus(String status,Appointment appointment) {
		
		Appointment id2 = new Appointment();
		id2=appointmentDao.getById(appointment.getId());
//		id2.setStatus(Status.APPROVED);
		id2.setStatus(Status.valueOf(status));
		
		return id2;
	}



	@Override
	public List<Appointment> pendingAppointments() {
		
		return appointmentDao.getPendingAppointment();
	}

	

}
