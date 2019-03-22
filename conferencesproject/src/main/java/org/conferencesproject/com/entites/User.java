package org.conferencesproject.com.entites;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",discriminatorType=DiscriminatorType.STRING,length=8)
public class User {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long   idUser;
	private String userFullName;
	private String email;
	private String password;
	private String profession;
	
	


	
	public User(String userFullName, String email, String password, String profession) {
		super();
		this.userFullName = userFullName;
		this.email = email;
		this.password = password;
		this.profession = profession;
		
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	
}
