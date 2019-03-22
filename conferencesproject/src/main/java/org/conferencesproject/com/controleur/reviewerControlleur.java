package org.conferencesproject.com.controleur;

import org.conferencesproject.com.entites.author;
import org.conferencesproject.com.service.adminService;
import org.conferencesproject.com.service.reviewerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/reviewer")
public class reviewerControlleur {
	 @Autowired
	 private reviewerService reviewer; 
	 @Autowired
	 private adminService admin;
	 @RequestMapping(value="/index")
	 public String index(Model model) {	
	    	model.addAttribute("User",  new author());
			model.addAttribute("isConnected",  reviewerService.isConnected );
			model.addAttribute("currentUser", reviewer.getCurrentUsers());
			model.addAttribute("lastEvent", admin.findLastEvent());
			model.addAttribute("speakers", admin.getallSpeakers().size());
	    	return  "index";
	 }
	 @RequestMapping(value="/Sponsors")
	 public String Sponsors(Model model) {	
	    	model.addAttribute("User",  new author());
			model.addAttribute("isConnected",  reviewerService.isConnected );
			model.addAttribute("currentUser", reviewer.getCurrentUsers());
	    	return  "Sponsors";
	 }
	   @RequestMapping(value="/logout", method=RequestMethod.GET)
	    public String logout(Model model) {	
        	model.addAttribute("isConnected",  reviewerService.isConnected=false);
				return  "redirect:/Author/index";
		}
	   @RequestMapping(value="/allArticle")
	   public String alllist(Model model) {
			 model.addAttribute("articles", reviewer.getAll());
				model.addAttribute("currentUser", reviewer.getCurrentUsers());
			 model.addAttribute("isConnected",  reviewerService.isConnected );
			  return "articleReviewer";
		  }
	    @RequestMapping(value="/validArticle")
		public String validArticle( Long id) {
			this.reviewer.validArticle(id);
			return "redirect:/reviewer/allArticle";
		}
		@RequestMapping(value="/rejectArtcle")
		public String rejectartcle(Long id) {
			this.reviewer.rejectartcle(id);
			return "redirect:/reviewer/allArticle";
		}
}
