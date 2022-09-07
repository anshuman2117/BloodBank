package com.app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.core.sym.Name;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*+-----------------+----------+------+-----+---------+----------------+
| Field           | Type     | Null | Key | Default | Extra          |
+-----------------+----------+------+-----+---------+----------------+
| id              | int      | NO   | PRI | NULL    | auto_increment |
| userid          | int      | NO   | UNI | NULL    |                |
| otp_code        | int      | NO   |     | NULL    |                |
| otp_expiry_time | datetime | NO   |     | NULL    |                |
+-----------------+----------+------+-----+---------+----------------+
*/
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

@Table(name = "forgetPasswords")
public class Forgetpassword extends BaseEntity {
	
	@Column(name= "user_id")
	private int user_id;
	
	@Column(name= "OTP")
	private int otp;
	
	@Column(name= "OTP_expiry_time")
	private Date otp_expiry_time;

	public Forgetpassword(int user_id, int otp, Date otp_expiry_time) {
		super();
		this.user_id = user_id;
		this.otp = otp;
		this.otp_expiry_time = otp_expiry_time;
	}
	
	
	
}
