package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Appointment;
import com.app.entities.Status;

public interface IAppointmentDao extends JpaRepository<Appointment,Long> {

	
	// method to get the current status of  scheduled appointment status of users
	@Query("select a.status from Appointment a where a.user =:id ")
	public String  getStatusById(@Param("id")Long id);
	
	//method to set the scheduled appointment status of users by admin
	@Modifying
	@Query(value = "UPDATE Appointment a SET a.status =:sts where a.user=:id")
	public void updateAppointmentStatus(@Param("sts") Status status,@Param("id") Long id);
	
	
}
