package com.EventTicket.EventTicket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="distributor")
public class Distributor {

	@Id
	@Column(name="idDistributor",unique=true)
	private int id;
	
	@Column(name="DistributorUsername",unique=true)
	private String username;
	
	@Column(name="DistributorPW")
	private String password;
	
	@Column(name="Distributorrating")
	private double rating;
}
