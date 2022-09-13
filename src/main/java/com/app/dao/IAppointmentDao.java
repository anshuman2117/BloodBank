package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Appointment;
import com.app.entities.Status;

public interface IAppointmentDao extends JpaRepository<Appointment,Long> {

	
	// method to get the current status of  scheduled appointment status of users
	@Query("select a from Appointment a where a.status ='PENDING'")
	public List<Appointment>  getPendingAppointment();
	
	//method to set the scheduled appointment status of users by admin
	@Modifying
	@Query(value = "UPDATE Appointment a SET a.status =:sts where a.user=:id")
	public void updateAppointmentStatus(@Param("sts") String status,@Param("id") Long id);
	
	
}
