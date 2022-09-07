package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "users")
public class User extends BaseEntity {
	
	@Column(length = 25)
	private String firstName;
	
	@Column(length = 25)
	private String lastName;
	
	@Column(length = 30, unique = true)
	private String email;
	
	@Column(length = 20)
	private String password;
	
	@Column(name = "contact_number",length = 15)
	private String mobNo;
	
	private int age;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name = "profile_image")
	private String image;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	

	
}
