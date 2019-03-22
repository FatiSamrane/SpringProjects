package org.conferencesproject.com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.conferencesproject.com.DAO.UserRepository;
import org.conferencesproject.com.DAO.articleRepository;
import org.conferencesproject.com.entites.User;
import org.conferencesproject.com.entites.article;
import org.conferencesproject.com.entites.author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
	 public static User authorUser = new author();
	 public static String userName;
	 public static Boolean isConnected = false ;
	 @Autowired
	 private UserRepository userRepository;
	 @Autowired
	 private articleRepository articleRepository;
	 
	 
	    @Transactional
	    public User authorInscription (author user) {      
	    	return  userRepository.save(user);
	    }
	    @Transactional
		public Integer userExist(String username , String password) {
	    	User user = null;
	    	 user = this.userRepository.findUserByEmailAndPassword(username, password);
			if(user!=null) {
				System.out.println(user.getClass().getSimpleName());
				if(user.getClass().getSimpleName().equals("author")){
					      isConnected = true;
					      authorUser  = user;
					      userName    = user.getUserFullName();
					return 1;  
				}
				else if (user.getClass().getSimpleName().equals("reviewer") ) {
					   reviewerService.isConnected  = true;
					   reviewerService.reviewerUser = user;
					 
					return 2;
				}
				else if (user.getClass().getSimpleName().equals("admin") ) {
					adminService.isConnected = true;
					adminService.adminUser = user;
					return 3;
				}
				else {
					return 0;
					}
			}
			else
				return 7;
			
		}
	      @Transactional
	      public User getCurrentUsers() {
		    	
	    		return   authorUser ; 
		      
		 }
	    @Transactional
	    public article addArticle(article ar) {
	    	ar.setStatus(false);
	    	return  articleRepository.save(ar);
	    }
	    @Transactional
	    public List<article> getAll(){
	    	return articleRepository.findAll();
	    }
	    @Transactional
	    public article getArticle(Long id){
	    	return articleRepository.getOne(id);
	    }
	    @Transactional
	    public void deletArticle(Long id) {
	    	articleRepository.deleteById(id);
	    }
}
