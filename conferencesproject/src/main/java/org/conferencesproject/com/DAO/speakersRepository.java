package org.conferencesproject.com.DAO;


import org.conferencesproject.com.entites.speakers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface speakersRepository extends JpaRepository<speakers, Long>{

}