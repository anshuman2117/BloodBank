package com.app.pojo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "appointments")
public class Appointment extends BaseEntity{

	private int user_id;
	private Date appointment_creation_date;
	private Date appointment_schedule_date;
	private Center center;
	@Column(name = "bag_size")
	private int bagSize;
	@Column(name = "bag_quantity")
	private int bagQuantity;
	private Status status;
	
	public Appointment(int user_id, Date appointment_schedule_date, Center center, int bagSize, int bagQuantity,
			Status status) {
		super();
		this.user_id = user_id;
		this.center = center;
		this.appointment_creation_date = Timestamp.valueOf(LocalDateTime.now());
		this.appointment_schedule_date = appointment_schedule_date;
		this.bagSize = bagSize;
		this.bagQuantity = bagQuantity;
		this.status = status;
	}
	
	
}
