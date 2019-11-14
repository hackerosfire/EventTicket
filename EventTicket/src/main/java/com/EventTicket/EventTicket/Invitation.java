package com.EventTicket.EventTicket;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="invitation")
public class Invitation {
@Id
@Column(name="idInvitation", unique=true)
private int id;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "idOrganisator")
private Organisator organisatorID;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "idDistributor")
private Distributor distributorID;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "idEvent")
private Event eventID;
@Column(name="invitationstatus")
private int status;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Organisator getOrganisatorID() {
	return organisatorID;
}
public void setOrganisatorID(Organisator organisatorID) {
	this.organisatorID = organisatorID;
}
public Distributor getDistributorID() {
	return distributorID;
}
public void setDistributorID(Distributor distributorID) {
	this.distributorID = distributorID;
}
public Event getEventID() {
	return eventID;
}
public void setEventID(Event eventID) {
	this.eventID = eventID;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
}
