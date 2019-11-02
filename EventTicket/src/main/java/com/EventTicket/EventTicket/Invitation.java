package com.EventTicket.EventTicket;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="invitation")
public class Invitation {
@Id
@Column(name="idInvitation", unique=true)
private int id;
@Column(name="organisatorid")
@OneToOne
private Organisator organisatorID;
@Column(name="distributorid")
@OneToOne
private Distributor distributorID;
@Column(name="eventid")
@OneToOne
private Event eventID;
@Column(name="invitationstatus")
private int status;
}
