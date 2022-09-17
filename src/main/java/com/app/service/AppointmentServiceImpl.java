package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.app.dao.IAppointmentDao;
import com.app.dto.AppointmentDTO;
import com.app.entities.Appointment;
import com.app.entities.Status;

@Service
@Transactional
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	private IAppointmentDao appointmentDao;

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<Appointment> getAllAppointment() {

		return appointmentDao.findAll();
	}
	
	
	@Override
	public List<AppointmentDTO> pendingAppointments() {
		
		return appointmentDao.findByStatus(Status.PENDING).stream()
				.map(i->mapper.map(i,AppointmentDTO.class)).collect(Collectors.toList());
	}


	@Override
	public Appointment saveAppointment(Appointment appointment) {
		return appointmentDao.save(appointment);
	}


	@Override
	public int updateAppointmentsStatus(String status, Appointment appointment) {
		System.out.println("status-> "+ status+"  appointment-> "+appointment.toString());
		return appointmentDao.updateAppointmentStatus(Status.valueOf(status), appointment.getUser());
	}


	@Override
	public Appointment appointmentById(Long id) {
		
		return appointmentDao.findById(id).orElseThrow(()->new RuntimeException("appointment not found"));
	}


	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-------------------------------------------------------------------check it once------------------
   // doubt in this part
//	@Override
//	public void updateStatus(String status,Long id) {
//		if(status.toString().equals("REJECTED")) {
//			appointmentDao.deleteById(id);
//		}
//		else {
//		appointmentDao.updateAppointmentStatus(status,id);
//		}
//	}
//	public Appointment updateStatus(String status,Appointment appointment) {
//		
//		Appointment id2 = new Appointment();
//		id2=appointmentDao.getById(appointment.getId());
////		id2.setStatus(Status.APPROVED);
//		id2.setStatus(Status.valueOf(status));
//		
//		return id2;
//	}



	
	

}
