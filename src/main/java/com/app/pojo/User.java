package com.app.pojo;

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
@Table(name = "user_table")
public class User extends BaseEntity {
	
	@Column(length = 30)
	private String name;
	@Column(length = 30, unique = true)
	private String email;
	@Column(length = 20)
	private String password;
	@Column(length = 10)
	private String mobNo;
	@Column(length = 20)
	private String batch;
	@Column(length = 20)
	private String rollNo;

	public User(String email, String password, String batch, String rollNo) {
		this.email = email;
		this.password = password;
		this.batch = batch;
		this.rollNo = rollNo;
	}
}
