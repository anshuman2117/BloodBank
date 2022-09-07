package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
+---------------------+-------------------------------------------+------+-----+---------+----------------+
| Field               | Type                                      | Null | Key | Default | Extra          |
+---------------------+-------------------------------------------+------+-----+---------+----------------+
| id                  | int                                       | NO   | PRI | NULL    | auto_increment |
| Document_type       | enum('aadhar_card','PAN_card','Passport') | NO   |     | NULL    |                |
| Document_uniq_id    | varchar(25)                               | NO   | UNI | NULL    |                |
| user_id             | int                           		      | NO   | UNI | NULL    |                |
| verification_status | enum('done','')                		      | NO   |     | NULL    |                |
+---------------------+-------------------------------------------+------+-----+---------+----------------+
*/

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "identity_proofs")
public class identity_proof {
	
	@Column(name= "user_id")
	private int user_id;
	
	@Column(name = "document_type")
	private Document_type document_type;
	
	@Column(name = "document_id",length = 12)
	private String documemnt_uniqid_number;
	
	@Column(name = "verifiaction_status")
	private Verification_status status;

	public identity_proof(int user_id, Document_type document_type, String documemnt_uniqid_number,
			Verification_status status) {
		super();
		this.user_id = user_id;
		this.document_type = document_type;
		this.documemnt_uniqid_number = documemnt_uniqid_number;
		this.status = status;
	}
	
	

}
