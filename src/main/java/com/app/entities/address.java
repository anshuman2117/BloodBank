package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | int          | NO   | PRI | NULL    | auto_increment |
| entity_type | enum('')     | NO   |     | NULL    |                |
| entity_id   | int          | NO   |     | NULL    |                |
| city        | varchar(20)  | NO   |     | NULL    |                |
| state       | varchar(20)  | NO   |     | NULL    |                |
| pincode     | int          | NO   |     | NULL    |                |
| address     | varchar(255) | NO   |     | NULL    |                |
| is_default  | tinyint      | NO   |     | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+
*/
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "addresses")
public class address extends BaseEntity {
	
	@Column(name = "address_type")
	private Entity_type entity_type;
	
	@Column(name = "address_id")
	private int entity_id;
	
	//@Column(name = "city")
	@Column(length = 20)
	private String city;
	
	//@Column(name = "state")
	@Column(length = 20)
	private String state;
	
	//@Column(name = "pincode")
	private int pincode;
	
	//@Column(name = "address")
	private String address;
	
	@Column(name = "default")
	private boolean is_default;

	public address(Entity_type entity_type, int entity_id, String city, String state, int pincode,
			String address, boolean is_default) {
		super();
		//this.user_id = user_id;
		this.entity_type = entity_type;
		this.entity_id = entity_id;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.address = address;
		this.is_default = is_default;
	}
	
	
	
}
