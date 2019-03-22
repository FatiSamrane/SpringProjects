package org.conferencesproject.com.entites;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class event {

	 @Id @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long   idAevent;
	 private String  SUBJECT;
	 private String VENUE;
	 private Date eventDate;
	 private String nbTickets;
	 private String eventDay;
	 private String SEATS;
	 @ManyToOne(cascade=CascadeType.DETACH)
	 @JoinColumn(name="code_speaker")
     private speakers speakeruser;
	 
	 
	public event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public event(String sUBJECT, String vENUE, Date eventDate, String nbTickets, String eventDay, String sEATS,
			speakers speakeruser) {
		super();
		this.SUBJECT = sUBJECT;
		this.VENUE = vENUE;
		this.eventDate = eventDate;
		this.nbTickets = nbTickets;
		this.eventDay = eventDay;
		this.SEATS = sEATS;
		this.speakeruser = speakeruser;
	}

	public event(String sUBJECT, String vENUE, Date eventDate, String nbTickets, String sEATS, speakers speakeruser) {
		super();
		this.SUBJECT = sUBJECT;
		this.VENUE = vENUE;
		this.eventDate = eventDate;
		this.nbTickets = nbTickets;
		this.SEATS = sEATS;
		this.speakeruser = speakeruser;
	}
	public Long getIdAevent() {
		return idAevent;
	}
	public void setIdAevent(Long idAevent) {
		this.idAevent = idAevent;
	}
	
	public String getEventDay() {
		return eventDay;
	}
	public void setEventDay(String eventDay) {
		this.eventDay = eventDay;
	}
	public String getSUBJECT() {
		return SUBJECT;
	}
	public void setSUBJECT(String sUBJECT) {
		SUBJECT = sUBJECT;
	}
	public String getVENUE() {
		return VENUE;
	}
	public void setVENUE(String vENUE) {
		VENUE = vENUE;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getNbTickets() {
		return nbTickets;
	}
	public void setNbTickets(String nbTickets) {
		this.nbTickets = nbTickets;
	}
	public String getSEATS() {
		return SEATS;
	}
	public void setSEATS(String sEATS) {
		SEATS = sEATS;
	}
	public speakers getSpeakeruser() {
		return speakeruser;
	}
	public void setSpeakeruser(speakers speakeruser) {
		this.speakeruser = speakeruser;
	}
	 
}
