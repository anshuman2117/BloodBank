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
	
	@Override
	public String getAppointmentStatus(Long id) {
		
		return appointmentDao.getStatusById(id);
	}

	@Override
	public void updateStatus(Status status,Long id) {
//		appointmentDao.updateAppointmentStatus(status,id);
		
	}

	

}
