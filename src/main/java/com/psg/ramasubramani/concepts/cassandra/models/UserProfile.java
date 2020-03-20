package com.psg.ramasubramani.concepts.cassandra.models;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * @author rn5
 *
 */
@Table(value = "users")
public class UserProfile {
	
	@PrimaryKeyColumn(value = "userid", type = PrimaryKeyType.PARTITIONED)
	private UUID userId;
	
	@Column(value = "firstname")
	private String firstname;
	
	@Column(value = "lastname")
	private String lastname;
	
	@Column(value = "email")
	private String email;
	
	@Column(value = "created_date")
	private Date createdDate;

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
