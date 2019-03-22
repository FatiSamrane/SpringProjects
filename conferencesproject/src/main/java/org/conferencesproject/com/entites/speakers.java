package org.conferencesproject.com.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class speakers {

	 @Id @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long   idSpeaker;
	 private String nameSpeaker;
	 private String proffesion;
	 @Lob
	 private String Personal_Information;
	 @Lob
	 private String Personal_Skills;
	 
	 
	public speakers(String nameSpeaker, String proffesion, String personal_Information, String personal_Skills) {
		super();
		this.nameSpeaker = nameSpeaker;
		this.proffesion = proffesion;
		Personal_Information = personal_Information;
		Personal_Skills = personal_Skills;
	}
	public speakers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdSpeaker() {
		return idSpeaker;
	}
	public void setIdSpeaker(Long idSpeaker) {
		this.idSpeaker = idSpeaker;
	}
	public String getNameSpeaker() {
		return nameSpeaker;
	}
	public void setNameSpeaker(String nameSpeaker) {
		this.nameSpeaker = nameSpeaker;
	}
	public String getProffesion() {
		return proffesion;
	}
	public void setProffesion(String proffesion) {
		this.proffesion = proffesion;
	}
	public String getPersonal_Information() {
		return Personal_Information;
	}
	public void setPersonal_Information(String personal_Information) {
		Personal_Information = personal_Information;
	}
	public String getPersonal_Skills() {
		return Personal_Skills;
	}
	public void setPersonal_Skills(String personal_Skills) {
		Personal_Skills = personal_Skills;
	}
	 
}
