package com.myTube.demo.Controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myTube.Entities.Channel;
import com.myTube.Entities.User;
import com.myTube.Repositories.ChannelRepo;
import com.myTube.Repositories.UserRepo;
import com.myTube.Repositories.VideoRepo;
import com.myTube.Services.UserServiceImplimentation;
import com.myTube.web.dto.UserLogInDTO;

@Controller
@RequestMapping(value="/Login")
public class LoginPageController {

	@Autowired
	public UserRepo userRepo;
	
	@Autowired
	public ChannelRepo channelRepo;
	
	@Autowired
	public VideoRepo videoRepo;
	
	@ModelAttribute("User")
	public UserLogInDTO userLoginDTO()
	{
		return new UserLogInDTO();
	}
	
	@GetMapping
	public String LoginPage()
	{
		return "LoginPage";
	}
	
	@PostMapping()
	public String registerUserAccount(@ModelAttribute("User") @Valid UserLogInDTO loginDTO, BindingResult result, HttpSession session)
	{
		UserServiceImplimentation newUserService = new UserServiceImplimentation();
		User newUser = newUserService.createUserObject(loginDTO);
		
		User existing =  userRepo.findByUsername(newUser.getUsername());
		if(existing == null)
		{
			result.rejectValue("username", null, "The username entered is not current in use.");
		}
		
		existing =  userRepo.findByUsernameAndUserpassword(newUser.getUsername(), newUser.getUserpassword());
		
		if(existing == null)
		{
			result.rejectValue("userpassword", null, "Incorrect login details");
		}
		
		
		if(result.hasErrors())
		{
			return "LoginPage";
		}
		
		Channel existingUserChannel = channelRepo.findByUser(existing);
		
		session.setAttribute("user", existing);
		session.setAttribute("userChannel", existingUserChannel);
		
		return "MainPage";
	}
	
}
