package org.conferencesproject.com.entites;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AUTHOR")
public class author extends User {

	
	public author(String userFullName, String email, String password, String profession) {
		super(userFullName, email, password, profession);
		
	}

	public author() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
