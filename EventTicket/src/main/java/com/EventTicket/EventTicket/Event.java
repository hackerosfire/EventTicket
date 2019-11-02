package com.EventTicket.EventTicket;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Event")
public class Event {
@Id
@Column(name="idEvent", unique=true)
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
@Column(name="EventType")
@OneToOne
private EventType type;
}
