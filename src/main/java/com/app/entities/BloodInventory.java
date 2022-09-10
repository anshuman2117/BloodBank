package com.app.entities;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "blood_inventory")
public class BloodInventory extends BaseEntity {

	@Column(name = "blood_group",length = 10)
	@Enumerated(EnumType.STRING)
	private BloodGroup bloodGroup;
	
	@Column(name = "bag_size",length = 10)
	private String bagSize;
	
	@Column(name = "bag_quantity")
	private int bagQuantity;
	
	@Column(name = "last_updated_date")
	private LocalDate lastUpdatedDate;

	public BloodInventory(BloodGroup bloodGroup, String bagSize, int bagQuantity) {
		super();
		this.bloodGroup = bloodGroup;
		this.bagSize = bagSize;
		this.bagQuantity = bagQuantity;
		this.lastUpdatedDate=LocalDate.now();
	}
	
	
}
