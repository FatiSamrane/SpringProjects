package org.conferencesproject.com.entites;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHAIR")
public class chair extends User{

	public chair() {
		super();
		// TODO Auto-generated constructor stub
	}

	public chair(String userFullName, String email, String password, String profession) {
		super(userFullName, email, password, profession);
		// TODO Auto-generated constructor stub
	}
 
	
}
