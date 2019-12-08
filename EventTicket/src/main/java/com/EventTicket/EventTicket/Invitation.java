package com.EventTicket.EventTicket;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;
import javax.persistence.Table;
@Entity
@Table(name="invitation")
public class Invitation {
@Id
@Column(name="idInvitation", unique=true)
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@ManyToOne(cascade = CascadeType.MERGE)
@JoinColumn(name = "organisatorid")
private Organisator organisatorID;
@OneToOne(cascade = CascadeType.MERGE)
@JoinColumn(name = "distributorid")
private Distributor distributorID;
@OneToOne(cascade = CascadeType.MERGE)
@JoinColumn(name = "eventid")
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
	@Override
	public String toString() {
		return getEventID().getName();
	}
	
}
