package org.conferencesproject.com.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.conferencesproject.com.DAO.eventRepository;
import org.conferencesproject.com.DAO.speakersRepository;
import org.conferencesproject.com.entites.User;
import org.conferencesproject.com.entites.admin;
import org.conferencesproject.com.entites.event;
import org.conferencesproject.com.entites.speakers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminService {

	 public static User adminUser = new admin();
	 public static Boolean isConnected = false ;
	 @Autowired
	 public speakersRepository spk;
	 @Autowired
	 public eventRepository en;
	 @Transactional
	 public speakers addSpkear(speakers sp) {
		 return spk.save(sp);
	 }
	 @Transactional
	 public speakers getspkear(Long id) {
		 return spk.getOne(id);
	 }
	 @Transactional
	 public List<speakers> getallSpeakers(){
		 return spk.findAll();
	 }
	 @Transactional
	 public event addEvent(event event, Long id) {
		 speakers sp = spk.getOne(id);
		 event.setSpeakeruser(sp);
		 event.setEventDate(new Date());
	 	return en.save(event);
	 }
	 @Transactional
	 public event findLastEvent() {
		 return en.findTopByOrderByIdAeventDesc();
	 }
	 @Transactional
	 public void deletspkear(Long id) {
		 spk.deleteById(id);
	 }
	 @Transactional
	 public List<event> getallEvents(){
		 return en.findAll();
	 }
	 @Transactional
	 public void deletEvent(Long id) {
		 en.deleteById(id);
	 }
}
