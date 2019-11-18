package com.EventTicket.EventTicket;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Event")
public class Event {
@Id
@Column(name="idEvent", unique=true)
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column(name="Eventcapacity")
private int capacity;
@Column(name="Eventticketprice")
private double price;
@Column(name="Eventticketperperson")
private int perPerson;
@Column(name="EventStatus")
private String status;
@Column(name="EventLocation")
private String location;
@Column(name="EventDate")
private Date date;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "idEventType")
private EventType type;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getCapacity() {
	return capacity;
}

public void setCapacity(int capacity) {
	this.capacity = capacity;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public int getPerPerson() {
	return perPerson;
}

public void setPerPerson(int perPerson) {
	this.perPerson = perPerson;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public EventType getType() {
	return type;
}

public void setType(EventType type) {
	this.type = type;
}
}
