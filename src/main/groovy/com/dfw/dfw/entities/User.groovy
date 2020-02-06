package com.dfw.dfw.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="user")
class User {
	
	@Id
	@Column(name="user_id")
	int user_id;
	
	@Column(name="first_name")
	String firstName
	
	@Column(name="last_name")
	String lastName
	
	@Column(name="phone_number")
	String phoneNumber
	
	@Column(name="email_address")
	String emailAddress
	
	@Column(name="user_type")
	String userType
	
}
