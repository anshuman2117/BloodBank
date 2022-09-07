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
public class blood_donations {
	
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "blood_sample_id",length = 12)
	private int blood_sample_id;
	
	@Column(name = "blood_group")
	private BloodGroup bloodGroup;
	
	@Column(name = "bag_size")
	private int bagSize;
	
	@Column(name = "bag_quantity")
	private int bagQuantity;
	
	@Column(name = "donation_date")
	private Date date_of_donation;
	
	@Column(name = "creation_date")
	private Date creation_date;

	public blood_donations(int user_id, int blood_sample_id, BloodGroup bloodGroup, int bagSize, int bagQuantity,
			Date date_of_donation, Date creation_date) {
		super();
		this.user_id = user_id;
		this.blood_sample_id = blood_sample_id;
		this.bloodGroup = bloodGroup;
		this.bagSize = bagSize;
		this.bagQuantity = bagQuantity;
		this.date_of_donation = date_of_donation;
		this.creation_date = creation_date;
	}
	
	
}
