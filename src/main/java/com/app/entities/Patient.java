package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class Patient extends BaseEntity {

	@Column(length = 15)
	private String name;
	@Column(length = 7)
	private String gender;
	
	private int age;
	@Column(length = 15)
	private String doctorName;
	
	private String description;
	
}
