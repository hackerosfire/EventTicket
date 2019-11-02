package com.EventTicket.EventTicket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="eventtype")
public class EventType {
@Id
@Column(name="idEventType",unique=true)
private int id;

@Column(name="EventTypeName")
private String type;
}
