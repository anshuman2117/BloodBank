package com.app.entities;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
+------------------+-------------------------------------------------+------+-----+---------+----------------+
| Field            | Type                                            | Null | Key | Default | Extra          |
+------------------+-------------------------------------------------+------+-----+---------+----------------+
| id               | int                                             | NO   | PRI | NULL    | auto_increment |
| user_id          | int                                             | NO   | MUL | NULL    |                |
| blood_sample_id  | varchar(20)                                     | NO   |     | NULL    |                |
| blood_group      | enum('O+','O-','AB+','AB-','A+','A-','B+','B-') | NO   |     | NULL    |                |
| Bag_size         | int                                             | NO   |     | NULL    |                |
| bag_quantity     | int                                             | NO   |     | NULL    |                |
| date_of donation | date                                            | NO   |     | NULL    |                |
| Creation_date    | date                                            | NO   |     | NULL    |                |
+------------------+-------------------------------------------------+------+-----+---------+----------------+
*/
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "blood_donations")
public class BloodDonation extends BaseEntity {
	
	@ManyToOne   // one user can donate many times
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "blood_sample_id",length = 12)
	private int blood_sample_id;
	
	@Column(name = "blood_group",length = 10)
	@Enumerated(EnumType.STRING)
	private BloodGroup bloodGroup;
	
	@Column(name = "bag_size")
	private int bagSize;
	
	@Column(name = "bag_quantity")
	private int bagQuantity;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "donation_date")
	private LocalDate date_of_donation;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "creation_date")
	private LocalDate creation_date;

	public BloodDonation(User user, int blood_sample_id, BloodGroup bloodGroup, int bagSize, int bagQuantity,
			LocalDate date_of_donation, LocalDate creation_date) {
		super();
		this.user = user;
		this.blood_sample_id = blood_sample_id;
		this.bloodGroup = bloodGroup;
		this.bagSize = bagSize;
		this.bagQuantity = bagQuantity;
		this.date_of_donation = date_of_donation;
		this.creation_date = creation_date;
	}
	
	
}
