package com.gyakorlas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyakorlas.entity.Message;
import com.gyakorlas.entity.User;
import com.gyakorlas.service.EmailService;
import com.gyakorlas.service.UserServiceImpl;

@Controller
public class HomeController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private EmailService emailService;
	 
	 @RequestMapping("/login")
		public String bejelentkezo(){
			return "bejelentkezes";
		}
	 
	 @RequestMapping("/registration")
		public String regisztracio(Model model){
			model.addAttribute("user", new User());
			return "regisztracio";
		} 
	  
	
	 @PostMapping("/reg")
	    public String greetingSubmit(@ModelAttribute User user, Model model) {
		 
			String valami = userServiceImpl.registerUser(user);		
			
			if(valami.equals("alreadyExists")) {
				model.addAttribute("hiba","");
				return "regisztracio";
			}
				
			if(user.getEnabled()==false) {
				model.addAttribute("aktivalas","");
				return "bejelentkezes";
			}
			
			return "bejelentkezes";
	    }
	 
	 @GetMapping("/activation/{code}")
	    public String activation(@PathVariable("code") String code, Model model) {
		userServiceImpl.userActivation(code);
		model.addAttribute("aktivalt","");
		return "bejelentkezes";
	 }
	 
	 @RequestMapping("/")
		public String registration(Model model){
		 	model.addAttribute("message", new Message());
			return "kapcsolat";
		}
	 
	 @PostMapping("/send")
	    public String messageToMe(@ModelAttribute Message m, Model model) {
		 emailService.sendMessageToMe(m);
		 return "siker";
	 }	 
}

