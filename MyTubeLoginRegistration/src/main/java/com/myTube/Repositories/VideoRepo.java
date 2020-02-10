package com.myTube.Repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myTube.Entities.Channel;
import com.myTube.Entities.Video;

public interface VideoRepo extends JpaRepository<Video, Integer>{

	ArrayList<Video> findBychannel(Channel channel);
}
