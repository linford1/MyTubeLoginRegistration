package com.myTube.demo.Controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myTube.Entities.Channel;
import com.myTube.Entities.User;
import com.myTube.Repositories.ChannelRepo;
import com.myTube.Repositories.UserRepo;
import com.myTube.Services.ChannelServiceImplimentation;
import com.myTube.Services.UserServiceImplimentation;
import com.myTube.web.dto.ChannelCreationDTO;
import com.myTube.web.dto.UserRegistrationDTO;


@Controller
@RequestMapping(value="/Registration")
public class UserResgitrationController {

	@Autowired
	public UserRepo userRepo;
	
	@Autowired
	public ChannelRepo channelRepo;
	
	@ModelAttribute("User")
	public UserRegistrationDTO userRegDTO()
	{
		return new UserRegistrationDTO();
	}
	
	@GetMapping
	public String RegistrationPage(Model model)
	{
		return "RegistrationPage";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("User") @Valid UserRegistrationDTO userDTO, BindingResult result)
	{
		UserServiceImplimentation newUserService = new UserServiceImplimentation();
		ChannelServiceImplimentation newChannelService = new ChannelServiceImplimentation();
		
		User newUser = newUserService.createUserObject(userDTO);
		
		User existing =  userRepo.findByUseremail(newUser.getUseremail());
		
		if(existing != null)
		{
			result.rejectValue("useremail", null, "The email entered is currently in use, try another.");
		}
		
		 existing =  userRepo.findByUsername(newUser.getUsername());
		
		if(existing != null)
		{
			result.rejectValue("username", null, "The username entered is currently in use, try another.");
		}
		
		
		if(result.hasErrors())
		{
			return "RegistrationPage";
		}
		

		LocalDateTime now = LocalDateTime.now(); 
		newUser.setAccountcreationdate(now.toString());
		
		ChannelCreationDTO newChannelDTO = new ChannelCreationDTO();
		
		newChannelDTO.setUser(newUser);
		newChannelDTO.setChannelname(newUser.getUsername()+"'s Channel");
		newChannelDTO.setChannelfollowers(new ArrayList<Integer>());
		newChannelDTO.setChannelVideos(new ArrayList<Integer>());
		
		Channel newChannel = newChannelService.createChannel(newChannelDTO);
		
		userRepo.saveAndFlush(newUser);
		channelRepo.saveAndFlush(newChannel);
		
		return "LoginPage";
	}
}
