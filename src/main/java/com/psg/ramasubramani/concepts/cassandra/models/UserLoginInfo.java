package com.psg.ramasubramani.concepts.cassandra.models;

import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * @author rn5
 *
 */
@Table(value = "user_login")
public class UserLoginInfo {
	
	@PrimaryKeyColumn(value = "email", type = PrimaryKeyType.PARTITIONED)
	private String email;
	
	@Column(value = "userid")
	private UUID userid;
	
	@Column(value = "password")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UUID getUserid() {
		return userid;
	}

	public void setUserid(UUID userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
