package com.myTube.demo.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myTube.Repositories.ChannelRepo;
import com.myTube.Repositories.UserRepo;


@Controller
public class MainController {

	@Autowired
	public UserRepo userRepo;
	@Autowired
	public ChannelRepo channelRepo;
	
	   @GetMapping("/")
	    public String root() {
	        return "redirect:Login";
	    }
	   
	   @GetMapping("/MainPage")
	    public String MainPage(Model model, HttpSession session) {
		   
		   model.addAttribute("user", session.getAttribute("user"));
		   
	       return "MainPage";
	    }
	   
	
	
}
