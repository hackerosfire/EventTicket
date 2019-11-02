package com.EventTicket.EventTicket;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="ticket")
public class Ticket {
@Id
@Column(name="idTICKET", unique=true)
private int id;
@Column(name="TICKETfirstname")
private String fName;
@Column(name="TICKETlastname")
private String lName;
@Column(name="TICKETegn")
private int EGN;
@Column(name="TICKETdistributor")
@OneToOne
private Distributor distributorID;
@Column(name="TICKETevent")
@OneToOne
private Event eventID;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getfName() {
	return fName;
}
public void setfName(String fName) {
	this.fName = fName;
}
public String getlName() {
	return lName;
}
public void setlName(String lName) {
	this.lName = lName;
}
public int getEGN() {
	return EGN;
}
public void setEGN(int eGN) {
	EGN = eGN;
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

}