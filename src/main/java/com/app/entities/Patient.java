package com.app.entities;

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

	
	private String name;
	private String gender;
	private int age;
	private String doctorName;
	private String description;
	
}
