package com.EventTicket.EventTicket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="eventtype")
public class EventType {
@Id
@Column(name="idEventType",unique=true)
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

@Column(name="EventTypeName")
private String type;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}
}
