package org.conferencesproject.com.entites;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("REVIEWER")
public class reviewer extends User {

	public reviewer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public reviewer(String userFullName, String email, String password, String profession) {
		super(userFullName, email, password, profession);
		// TODO Auto-generated constructor stub
	}

	 
}
