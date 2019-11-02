package com.EventTicket.EventTicket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="organisator")
public class Organisator {
	@Id
	@Column(name="idOrganisator",unique=true)
	private int organisatorid;
	
	@Column(name="OrganisatorUsername",unique=true)
	private String username;
	
	@Column(name="OrganisatorPW",nullable=false)
	private String password;

	public int getOrganisatorid() {
		return organisatorid;
	}

	public void setOrganisatorid(int organisatorid) {
		this.organisatorid = organisatorid;
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
