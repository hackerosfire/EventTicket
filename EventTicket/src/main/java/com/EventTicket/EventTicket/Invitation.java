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
}
