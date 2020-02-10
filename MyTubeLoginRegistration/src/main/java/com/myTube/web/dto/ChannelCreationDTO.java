package com.myTube.web.dto;


import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.myTube.Entities.User;

public class ChannelCreationDTO {
	
	@NotEmpty
	private String channelname;
	
	@NotEmpty
	private List<Integer> channelfollowers;
	
	@NotEmpty
	private List<Integer> channelVideos;
	
	@NotEmpty
	private User user;

	public String getChannelname() {
		return channelname;
	}

	public void setChannelname(String channelname) {
		this.channelname = channelname;
	}

	public List<Integer> getChannelfollowers() {
		return channelfollowers;
	}

	public void setChannelfollowers(List<Integer> channelfollowers) {
		this.channelfollowers = channelfollowers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getChannelVideos() {
		return channelVideos;
	}

	public void setChannelVideos(List<Integer> channelVideo) {
		this.channelVideos= channelVideo;
	}
	
}
