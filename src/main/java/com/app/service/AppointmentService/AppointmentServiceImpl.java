package com.app.service.AppointmentService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.app.custom_excpetions.ResourceNotFoundException;
import com.app.dao.IAddressDao;
import com.app.dao.IAppointmentDao;
import com.app.dao.IBloodInventoryDao;
import com.app.dao.IPatientDao;
import com.app.dao.IUserDao;
import com.app.dto.AppointmentDTO;
import com.app.entities.Appointment;
import com.app.entities.Patient;
import com.app.entities.Status;
import com.app.entities.User;
import com.app.service.IEmailSendingService;
import com.app.service.BloodInventoryService.IBloodInventoryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	private IAppointmentDao appointmentDao;

	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private IBloodInventoryDao bloodInventoryDao;
	
	@Autowired
	private IBloodInventoryService bloodInventoryService;

	@Autowired
	private IEmailSendingService emailSendingService;

	@Autowired
	private IAddressDao addressDao;

	@Autowired
	private IPatientDao patientDao;
	
	
	// method  to return all the appointment(can be used to check history of appointment)
	@Override
	public List<AppointmentDTO> getAllAppointment() {

		return appointmentDao.findAllAppointment()
				.stream()
				.map(i->mapper.map(i, AppointmentDTO.class))
				.collect(Collectors.toList());
	}

	
	
	// methood to return list of all pending  appointment
	@Override
	public List<AppointmentDTO> pendingAppointments() {

		List<AppointmentDTO> appointmentDTOs= appointmentDao.findByStatus(Status.PENDING)
				.stream()
				.map(i -> mapper.map(i, AppointmentDTO.class))
				.collect(Collectors.toList());
//		List<AppointmentDTO> appointmentDTOs=appointmentDao.findByStatus(Status.PENDING);
		
		 return appointmentDTOs;
	}

//	@Override
//	public Appointment saveAppointment(Appointment appointment) {
//		return appointmentDao.save(appointment);
//	}

	@Override
	public boolean updateAppointmentsStatus(String status, Appointment appointment) {
		
		
		int updatedsts = 0;
		log.warn("status-> " + status + "  appointment-> " + appointment.toString());
		
		String header = "YOUR APPOINTMENT  REQUEST  " + status;
		log.warn("----header -->" + header);
		String messageBody ="";
		if (addressDao.findUserAddress(appointment.getUser().getId()) != null) {
			updatedsts = appointmentDao.updateAppointmentStatus(Status.valueOf(status), appointment.getId());
			log.warn("----updatedsts--->  " +updatedsts );
			
			if (status.equalsIgnoreCase("APPROVED")) {
				
				if (updatedsts != 1 || bloodInventoryService.findByBloodGroupAndBagSize(appointment.getBloodGroup(),
						appointment.getBagSize())<appointment.getBagQuantity()) {
					return false;
				}
				log.warn("---reducing blood count---> " );
				bloodInventoryDao.subBloodCount(appointment.getBagQuantity(), LocalDate.now(), appointment.getBagSize(),
						appointment.getBloodGroup());
				
				log.warn("---inside mail sending condition checking ---> "  );
				 header = "YOUR APPOINTMENT  REQUEST  " + status;
				 messageBody = "hello <p><font color=blue>" + appointment.getUser().getFirstName() + "</font></p>"
						+ " your scheduled appointment status has been <font color=blue>" + status
						+ " </font>  details are given bellow ." + "<table width='100%' border='1' align='center'>"
						+ "<tr align='center'>" + "<td><b>requesting person <b></td>"
						+ "<td><font size=10px,color=blue>" + appointment.getUser().getFirstName() + "</font><b></td>"
						+ "</tr>" + "<tr align='center'>" + "<td><b>requesting For<b></td>"
						+ "<td><font size=10px,color=blue>" + appointment.getPatient().getName() + "</font><b></td>"
						+ "</tr>" + "<tr align='center'>" + "<td><b>Blood Group<b></td>"
						+ "<td><font size=10px,color=blue>" + appointment.getBloodGroup() + "</font><b></td>" + "</tr>"
						+ "<tr align='center'>" + "<td><b>Bag Size<b></td>" + "<td><font size=10px,color=blue>"
						+ appointment.getBagSize() + "</font><b></td>" + "</tr>" + "<tr align='center'>"
						+ "<td><b>Bag Quantity<b></td>" + "<td><font size=10px,color=blue>"
						+ appointment.getBagQuantity() + "</font><b></td>" + "</tr>" + "<tr align='center'>"
						+ "<td><b>Appointment Schedule Date<b></td>" + "<td><font size=10px,color=blue>"
						+ appointment.getAppointmentScheduleDate() + "</font><b></td>" + "</tr>" + "<tr align='center'>"
						+ "<td><b>Appointment Scheduled Status<b></td>" + "<td><font size=10px,color=blue>"
						+ appointment.getAppointmentScheduleDate() + "</font><b></td>" + "</tr>"

				;                          
				 log.warn("----sending mail ---in approved condition-> " );
				emailSendingService.sendEmail(appointment.getUser().getEmail(),messageBody,header );
			} else {
				 log.warn("----sending mail ---in rejected condition-> " );
				 messageBody = messageBody
						+ " <font/> due to some reason .<p> <ul> unavaliability of blood</ul> "
						+ "<ul> you may have not registered your address(please register your address)</ul> </p>";
				emailSendingService.sendEmail(appointment.getUser().getEmail(), messageBody, header );
			}

		}

		return true;
	}

//	@Override
//	public Appointment appointmentById(Long id) {
//
//		return appointmentDao.findById(id).orElseThrow(() -> new RuntimeException("appointment not found"));
//	}
//
	
	// take appointment by user id
	// take patient id from appointment
	//
	
	
	// getting all the appointments created by a user 
	@Override
	public List<AppointmentDTO> getAppointmentByuserId(Long id) {
		List<AppointmentDTO> list = appointmentDao.findByUserId(id).stream().map(i->mapper.map(i, AppointmentDTO.class))
		.collect(Collectors.toList());
		return list;
	}
	
	// creating a  new appointment
	@Override
	public Appointment saveAppointment(Long userid, Appointment appointment, Patient patient) {
		Appointment appointment2;
		Patient byName = patientDao.findByName(patient.getName());
		if(byName!=null) {
			appointment.setPatient(byName);
			User user = userDao.findById(userid).orElseThrow(()->new ResourceNotFoundException("user does not have user id"+userid));
			appointment.setUser(user); 
			 appointment2 = appointmentDao.save(appointment);
			
		}
		else {
			Patient save = patientDao.save(patient);
			User user = userDao.findById(userid).orElseThrow(()->new ResourceNotFoundException("user does not have user id"+userid));
			appointment.setUser(user); 
			appointment.setPatient(save); 
			 appointment2 = appointmentDao.save(appointment);
		
		}
		return appointment2;
	}

	

}
