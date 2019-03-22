package org.conferencesproject.com.controleur;

import java.io.IOException;

import org.conferencesproject.com.entites.article;
import org.conferencesproject.com.entites.author;
import org.conferencesproject.com.entites.categorie;
import org.conferencesproject.com.service.adminService;
import org.conferencesproject.com.service.reviewerService;
import org.conferencesproject.com.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/Author")
public class authorControleur {

	 @Autowired
	 private userService authorService;
	 @Autowired
	 public adminService admin;
	 
	 @RequestMapping(value="/index")
	 public String index(Model model) {	
	    	model.addAttribute("User",  new author());
			model.addAttribute("isConnected",  userService.isConnected );
			model.addAttribute("currentUser", authorService.getCurrentUsers());
			model.addAttribute("lastEvent", admin.findLastEvent());
			model.addAttribute("speakers", admin.getallSpeakers().size());
	    	return  "index";
	 }
	 @RequestMapping(value="/Sponsors")
	 public String Sponsors(Model model) {	
	    	model.addAttribute("User",  new author());
			model.addAttribute("isConnected",  userService.isConnected );
			model.addAttribute("currentUser", authorService.getCurrentUsers());
	    	return  "Sponsors";
	 }
	 @RequestMapping(value="/inscription")
	 public String authorInscription(author c) {
		   authorService.authorInscription(c);
		   userService.isConnected = true;
		   return "redirect:/Author/login";
	 }
	 
	  @RequestMapping(value="/logout", method=RequestMethod.GET)
	  public String logout(Model model) {	
         	model.addAttribute("isConnected",  userService.isConnected=false);
				return  "redirect:/Author/index";
		}
	  @RequestMapping(value="/login")
	  public String login(Model model) {	
		    	
		    	return  "login";
		 }
	  @RequestMapping(value="/checkLogin", method=RequestMethod.POST)
	  public String checkLogin(@RequestParam("username") String username , @RequestParam("password") String password,Model model) {
				Integer userTypeIndex = this.authorService.userExist(username,password);
				System.out.println(authorService.userExist(username,password));
				if(userTypeIndex==1) {
					model.addAttribute("isConnected", userService.isConnected);
					System.out.println(userService.isConnected);
					return  "redirect:/Author/index";
				} 
				else if(userTypeIndex==2) {
					model.addAttribute("isConnected", reviewerService.isConnected);
					System.out.println(reviewerService.isConnected);
					return  "redirect:/reviewer/index";
				} 
				else if(userTypeIndex==3) {
					model.addAttribute("isConnected", adminService.isConnected);
					return  "redirect:/Admin/index";
				} 
				else return "login";
				
			}
	  
	  @RequestMapping(value="/addArticle")
	  public String addArticle(Model model) {	
		  model.addAttribute("isConnected",  userService.isConnected );
		  model.addAttribute("articles", new article());
		    	return  "addArticle";
		 }
	  @RequestMapping(value="/add")
	  public String add(Model model, article ar ,@RequestParam("category") String category,@RequestParam(name="pdf")MultipartFile pdf) throws IOException {	
		  ar.setCat_article(categorie.valueOf(category));
		  ar.setArtcilepdf(pdf.getBytes());
		  ar.setUser(userService.authorUser);
		  authorService.addArticle(ar);
		    	return  "redirect:/Author/addArticle";
		 }
	  @RequestMapping(value="/allArticle")
	  public String alllist(Model model) {
		 model.addAttribute("articles", authorService.getAll());
		 model.addAttribute("isConnected",  userService.isConnected );
		  return "myArticle";
	  }
	  @RequestMapping(value="/viewContentarticle", method=RequestMethod.GET)
	   public String viewContentEntreprise(Model model,Long id ) {
		  article ar = this.authorService.getArticle(id);
		  model.addAttribute("isConnected",  userService.isConnected );
		  model.addAttribute("article",  ar);
		 return "articleContent";
		}
	  @RequestMapping(value="/editArticle")
	   public String edit(Long id , Model model) {
		  model.addAttribute("isConnected",  userService.isConnected );
		  model.addAttribute("article", this.authorService.getArticle(id))	;
		 return "articleEpdate";
	 }
	  @RequestMapping(value="/update")
		 public String formUpdateReparation(article ar,Model model,@RequestParam("category") String category) {
	    	if(userService.isConnected) {
	    		  ar.setCat_article(categorie.valueOf(category));
	    		  ar.setUser(userService.authorUser);
			 this. authorService.addArticle(ar);
			 return "redirect:/Author/allArticle";
			 }
	    	else return  "redirect:/Author/login";
		 }
		
	  @RequestMapping(value="/supprimerArticle")
	    public String Supprimer(Long id,Model model) {
		  authorService.deletArticle(id);
 	    return "redirect:/Author/allArticle";
		   }
}
