package com.myTube.web.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.myTube.Entities.Channel;

public class VideoDTO {

	@NotEmpty
	private String videoname;
	
	@NotNull
	private float videolength;
	
	@NotNull
	private int videolikes;
	
	@NotNull
	private int videodislikes;
	
	@NotEmpty
	private String videodescription;
	
	@NotNull
	private MultipartFile videofile;
	

	private Channel channel;

	public String getVideoname() {
		return videoname;
	}

	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}

	public float getVideolength() {
		return videolength;
	}

	public void setVideolength(float videolength) {
		this.videolength = videolength;
	}

	public int getVideolikes() {
		return videolikes;
	}

	public void setVideolikes(int videolikes) {
		this.videolikes = videolikes;
	}

	public int getVideodislikes() {
		return videodislikes;
	}

	public void setVideodislikes(int videodislikes) {
		this.videodislikes = videodislikes;
	}

	public String getVideodescription() {
		return videodescription;
	}

	public void setVideodescription(String videodescription) {
		this.videodescription = videodescription;
	}


	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public MultipartFile getVideofile() {
		return videofile;
	}

	public void setVideofile(MultipartFile videofile) {
		this.videofile = videofile;
	}



	
}
