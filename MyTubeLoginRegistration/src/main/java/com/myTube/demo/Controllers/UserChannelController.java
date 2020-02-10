package com.myTube.demo.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myTube.Entities.Channel;
import com.myTube.Entities.User;
import com.myTube.Repositories.ChannelRepo;
import com.myTube.Repositories.UserRepo;
@Controller
@RequestMapping(value="/MyChannel")
public class UserChannelController 
{

		@Autowired
		public UserRepo userRepo;
		
		@Autowired
		public ChannelRepo channelRepo;
		
		
		@GetMapping
		public String MyChannelPage(Model model,HttpSession session)
		{
			Channel userChannel = (Channel)session.getAttribute("userChannel");
			
			model.addAttribute("userChannel", userChannel.getChannelname());
			
			model.addAttribute("user",(User)session.getAttribute("user"));
			
			return "UserChannelPage";
		}
		
		@PostMapping
		public String openUserChannel(Model model,HttpSession session)
		{
			
			return "UserChannelPage";
		}
}
		

