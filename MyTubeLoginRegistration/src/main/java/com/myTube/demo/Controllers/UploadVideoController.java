package com.myTube.demo.Controllers;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.myTube.Entities.Channel;
import com.myTube.Entities.Video;
import com.myTube.Repositories.ChannelRepo;
import com.myTube.Repositories.UserRepo;
import com.myTube.Repositories.VideoRepo;
import com.myTube.Services.ChannelServiceImplimentation;
import com.myTube.Services.VideoServiceImplimentation;
import com.myTube.web.dto.VideoDTO;

@Controller
@RequestMapping(value="/UploadVideo")
public class UploadVideoController {

	@Autowired
	public UserRepo userRepo;
	
	@Autowired
	public ChannelRepo channelRepo;
	
	@Autowired
	public VideoRepo videoRepo;
	
	@ModelAttribute("video")
	public VideoDTO videoDTO()
	{
		return new VideoDTO();
	}
	
	@GetMapping
	public String RegistrationPage(Model model)
	{
		return "UploadVideoPage";
	}
	
	@Bean(name="multipartResolver")
	 public CommonsMultipartResolver multipartResolver() {
	 CommonsMultipartResolver multi = new CommonsMultipartResolver();
	 multi.setMaxUploadSize(-1);

	 return multi;
	 }
	
	
	@PostMapping(consumes = {"multipart/form-data"})
	public String UploadVideo(@ModelAttribute("video") @Valid VideoDTO videoDTO, BindingResult result,HttpSession session,@RequestParam("videofile") MultipartFile  file)
	{
		
		VideoServiceImplimentation newVideoService = new VideoServiceImplimentation();
		ChannelServiceImplimentation newChannelService = new ChannelServiceImplimentation();
		
		videoDTO.setChannel((Channel)session.getAttribute("userChannel"));
		
		Video newVideo = newVideoService.CreateVideo(videoDTO);
		
		MultipartFile videoFile = videoDTO.getVideofile();
		
		newVideoService.UploadVideoFile(videoFile, videoDTO.getVideoname()+".mp4");
				
		if(videoDTO.getVideofile() == null)
		{
			result.rejectValue("video", null, "No Video File Added");	
		}
		
		if(result.hasErrors())
		{
			return "UploadVideoPage";
		}
		
		
		Channel  channelToAddVideo = channelRepo.findById(newVideo.getChannel().getChannelId()).orElseThrow(() -> new EntityNotFoundException());
		
		newChannelService.AddVideoToChannel(channelToAddVideo, newVideo);
		

		videoRepo.saveAndFlush(newVideo);
		channelRepo.saveAndFlush(channelToAddVideo);
		return "redirect:MyChannel";
	}
	
	
}
