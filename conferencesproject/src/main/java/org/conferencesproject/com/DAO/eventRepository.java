package org.conferencesproject.com.DAO;

import org.conferencesproject.com.entites.event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface eventRepository extends JpaRepository<event, Long>{
	/*for get the last event and 
	 * display in index page
	 * */
 event findTopByOrderByIdAeventDesc();
}