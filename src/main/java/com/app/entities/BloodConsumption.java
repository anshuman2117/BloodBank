package com.app.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
+----------------+-------------------------------------------------+------+-----+---------+----------------+
| Field          | Type                                            | Null | Key | Default | Extra          |
+----------------+-------------------------------------------------+------+-----+---------+----------------+
| id             | int                                             | NO   | PRI | NULL    | auto_increment |
| blood_group    | enum('O+','O-','AB+','AB-','A+','A-','B+','B-') | NO   |     | NULL    |                |
| appointment_id | int                                             | NO   | UNI | NULL    |                |
| bag_size       | int                                             | NO   |     | NULL    |                |
| bag_quantity   | int                                             | NO   |     | NULL    |                |
| pateint_id     | int                                             | NO   | MUL | NULL    |                |
| Creation_date  | date                                            | NO   |     | NULL    |                |
+----------------+-------------------------------------------------+------+-----+---------+----------------+
*/
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "blood_consumptions")
public class BloodConsumption extends BaseEntity{
	
	@Column(name = "blood_group",length = 10)
	@Enumerated(EnumType.STRING)
	private BloodGroup bloodGroup;
	
	@OneToOne
	@JoinColumn(name = "appointment_id")
	private Appointment appointmentId;
	
	@Column(name = "bag_size")
	private int bagSize;
	
	@Column(name = "bag_quantity")
	private int bagQuantity;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient pateint_id;
	
	@Column(name = "creation_date")
	private LocalDate creation_date;

	public BloodConsumption(BloodGroup bloodGroup, Appointment appointmentId, int bagSize, int bagQuantity, Patient pateint_id,
			LocalDate creation_date) {
		super();
		this.bloodGroup = bloodGroup;
		this.appointmentId = appointmentId;
		this.bagSize = bagSize;
		this.bagQuantity = bagQuantity;
		this.pateint_id = pateint_id;
		this.creation_date = creation_date;
	}
	
	
}
