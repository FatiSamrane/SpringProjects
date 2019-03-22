package org.conferencesproject.com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.conferencesproject.com.DAO.articleRepository;
import org.conferencesproject.com.entites.User;
import org.conferencesproject.com.entites.article;
import org.conferencesproject.com.entites.reviewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class reviewerService {

	 public static User reviewerUser = new reviewer();
	 public static Boolean isConnected = false ;
	 @Autowired
	 private articleRepository articleRepository;
	    
	    @Transactional
	    public List<article> getAll(){
	    	return articleRepository.findAll();
	    }
	 
	     @Transactional
		public void validArticle(Long artcleID) {
			this.articleRepository.getOne(artcleID).setStatus(true);
			
		}
		@Transactional
		public void rejectartcle(Long artcleID) {
			this.articleRepository.getOne(artcleID).setStatus(false);
		}
		@Transactional
	      public User getCurrentUsers() {
		    	
	    		return   reviewerUser ; 
		      
		 }
}
