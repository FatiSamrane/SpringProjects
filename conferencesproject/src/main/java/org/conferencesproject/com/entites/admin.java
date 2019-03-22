package org.conferencesproject.com.entites;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class admin extends User {

	public admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public admin(String email, String password) {
		super(email, password);
		// TODO Auto-generated constructor stub
	}

	 
}
