package com.EventTicket.EventTicket;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="admin")
public class Admin implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="idAdmin",unique=true)
	private int id;
	
	@Column(name="AdminUsername",unique=true)
	private String username;
	
	@Column(name="AdminPW",nullable =false)
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
