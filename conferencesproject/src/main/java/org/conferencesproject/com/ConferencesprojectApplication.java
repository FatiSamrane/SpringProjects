package org.conferencesproject.com;

import org.conferencesproject.com.DAO.UserRepository;
import org.conferencesproject.com.entites.User;
import org.conferencesproject.com.entites.admin;
import org.conferencesproject.com.entites.reviewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConferencesprojectApplication implements CommandLineRunner {
	 @Autowired
	 private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(ConferencesprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*User rev = new reviewer("salim", "salim@gmail.com", "123456", "jury");

		User re  = new reviewer("samran", "samran@gmail.com", "123456", "jury");

		User r   = new reviewer("khaoula", "khaoula@gmail.com", "123456", "jury");
		
		userRepository.save(rev);
		userRepository.save(re);
		userRepository.save(r);
		User u = new admin("naoufal@gmail.com", "123456");
		userRepository.save(u);*/
	}

}
