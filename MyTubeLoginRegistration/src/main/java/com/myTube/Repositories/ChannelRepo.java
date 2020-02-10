package com.myTube.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myTube.Entities.Channel;
import com.myTube.Entities.User;

public interface ChannelRepo extends JpaRepository<Channel,Integer>{

	Channel findByUser(User user);
}	
