package org.conferencesproject.com.controleur;


import org.conferencesproject.com.entites.admin;
import org.conferencesproject.com.entites.event;
import org.conferencesproject.com.entites.speakers;
import org.conferencesproject.com.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/Admin")
public class adminControlleur {

	@Autowired
	public adminService adm;
	
	 @RequestMapping(value="/index")
	 public String index(Model model) {	
			model.addAttribute("isConnected",  adminService.isConnected );
			model.addAttribute("speakres", adm.getallSpeakers());
			model.addAttribute("event", new event());
	    	return  "indexAdmin";
	 }
	 @RequestMapping(value="/speaker")
	 public String speker(Model model) {	
			model.addAttribute("isConnected",  adminService.isConnected );
			model.addAttribute("speaker", new speakers());
	    	return  "spekeradd";
	 }
	 @RequestMapping(value="/addSpker")
	 public String addSpker(Model model,speakers sp) {	
	        adm.addSpkear(sp);	 
			model.addAttribute("isConnected",  adminService.isConnected );
	    	return  "redirect:/Admin/speaker";
	 }
	 @RequestMapping(value="/addevent")
	 public String addEvent(Model model,event sp,@RequestParam("idSpeaker") Long idSpeaker) {	
	        adm.addEvent(sp,idSpeaker);	 
			model.addAttribute("isConnected",  adminService.isConnected );
	    	return  "redirect:/Admin/index";
	 }
	 @RequestMapping(value="/allSpeaker")
	 public String allSpeaker(Model model) {	
			model.addAttribute("isConnected",  adminService.isConnected );
			model.addAttribute("speakres", adm.getallSpeakers());
	    	return  "allSpeaker";
	 }
	 @RequestMapping(value="/supprimerSpk")
	    public String Supprimer(Long id,Model model) {
		  adm.deletspkear(id);
	    return "redirect:/Admin/allSpeaker";
		   }
	 @RequestMapping(value="/allevent")
	 public String allevent(Model model) {	
			model.addAttribute("isConnected",  adminService.isConnected );
			model.addAttribute("events", adm.getallEvents());
	    	return  "allevent";
	 }
	 @RequestMapping(value="/supprimerevent")
	    public String supprimerevent(Long id,Model model) {
		  adm.deletEvent(id);
	    return "redirect:/Admin/allevent";
		   }
}
