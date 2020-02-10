package com.myTube.Services;

import java.util.ArrayList;

import com.myTube.Entities.Channel;
import com.myTube.Entities.Video;
import com.myTube.web.dto.ChannelCreationDTO;

public class ChannelServiceImplimentation {

	public Channel createChannel(ChannelCreationDTO channel)
	{
		Channel newChannel = new Channel();
		newChannel.setChannelname(channel.getUser().getUsername()+"'s Channel");
		newChannel.setUser(channel.getUser());
		newChannel.setChannelfollowers(new ArrayList<Integer>());
		newChannel.setChannelvideos(new ArrayList<Integer>());
		return newChannel;
	}
	
	
	public void AddVideoToChannel(Channel channel, Video video)
	{
		channel.getChannelvideos().add(video.getVideoId());
	}
}
