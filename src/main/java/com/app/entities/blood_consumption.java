package com.app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class blood_consumption {
	
	@Column(name = "blood_group")
	private BloodGroup bloodGroup;
	
	@Column(name = "appointment_id")
	private int appointment_id;
	
	@Column(name = "bag_size")
	private int bagSize;
	
	@Column(name = "bag_quantity")
	private int bagQuantity;
	
	@Column(name = "pateint_id")
	private int pateint_id;
	
	@Column(name = "creation_date")
	private Date creation_date;

	public blood_consumption(BloodGroup bloodGroup, int appointment_id, int bagSize, int bagQuantity, int pateint_id,
			Date creation_date) {
		super();
		this.bloodGroup = bloodGroup;
		this.appointment_id = appointment_id;
		this.bagSize = bagSize;
		this.bagQuantity = bagQuantity;
		this.pateint_id = pateint_id;
		this.creation_date = creation_date;
	}
	
	
}
