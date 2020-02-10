package com.myTube.demo.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myTube.Repositories.ChannelRepo;
import com.myTube.Repositories.UserRepo;
import com.myTube.Repositories.VideoRepo;


@Controller
public class MainController {

	@Autowired
	public UserRepo userRepo;
	@Autowired
	public ChannelRepo channelRepo;
	@Autowired
	public VideoRepo videoRepo;
	
	   @GetMapping("/")
	    public String root() {
	        return "Index";
	    }
	   
	   @GetMapping("/MainPage")
	    public String MainPage(Model model, HttpSession session) {
		   
		   model.addAttribute("user", session.getAttribute("user"));
		   
	       return "MainPage";
	    }
	   

	    @GetMapping("/login")
	    public String login() {
	        return "login";
	    }
	
	
}
