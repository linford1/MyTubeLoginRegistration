package com.myTube.Services;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.myTube.Entities.Video;
import com.myTube.web.dto.VideoDTO;

public class VideoServiceImplimentation {
	
	private String videoStoragePath = "D:\\Eclipse Projects\\testFiles\\MytubeVersioned\\MyTube\\src\\VideoStorage\\";

	public Video CreateVideo(VideoDTO video)
	{
		Video newVideo = new Video();
		
		newVideo.setChannel(video.getChannel());
		newVideo.setVideodescription(video.getVideodescription());
		newVideo.setVideodislikes(video.getVideodislikes());
		newVideo.setVideolength(video.getVideolength());
		newVideo.setVideolikes(video.getVideolikes());
		newVideo.setVideoURL(videoStoragePath+video.getVideoname()+".mp4");
		newVideo.setVideoname(video.getVideoname());
		
		return newVideo;
	}
	
	public void UploadVideoFile(MultipartFile video, String videoName)
	{
		try
		{
		video.transferTo(new File(videoStoragePath+videoName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
