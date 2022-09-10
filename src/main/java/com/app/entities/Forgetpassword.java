package com.app.entities;



import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

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

@Table(name = "forget_Passwords")
public class ForgetPassword extends BaseEntity {
	
	@JoinColumn(name = "user_id")
	@OneToOne
	private User user;
	
	@Column(name= "OTP")
	private long otp;
	
	@Column(name= "OTP_expiry_time")
	private LocalDateTime otp_expiry_time;

	public ForgetPassword(User user, int otp, LocalDateTime otp_expiry_time) {
		super();
		this.user = user;
		this.otp = otp;
		this.otp_expiry_time = otp_expiry_time;
	}
	
	
	
}
