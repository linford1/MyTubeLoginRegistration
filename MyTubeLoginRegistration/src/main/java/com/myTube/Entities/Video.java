package com.myTube.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Videos")
public class Video{


	@Id
	@Column(name="Video_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int videoId;
	
	
	@Column(name="Video_Name")
	private String videoname;
	
	@Column(name="Video_Length")
	private float videolength;
	
	@Column(name="Video_Likes")
	private int videolikes;
	
	@Column(name="Video_Dislikes")
	private int videodislikes;
	
	@Column(name="Video_Description")
	private String videodescription;
	
	@Column(name="Video_URL")
	private String videoURL;

	@ManyToOne
	@JoinColumn(name="VideoChannel")
	private Channel channel;
	
	public Video()
	{
		
	}
	
	
	
	public Video(String videoname, float videolength, String videodescription, String videoURL) {
		super();
		this.videoname = videoname;
		this.videolength = videolength;
		this.videodescription = videodescription;
		this.videoURL = videoURL;
	}



	public Video(String videoname, float videolength, int videolikes, int videodislikes, String videodescription,
			String videoURL, Channel channel) {
		super();
		this.videoname = videoname;
		this.videolength = videolength;
		this.videolikes = videolikes;
		this.videodislikes = videodislikes;
		this.videodescription = videodescription;
		this.videoURL = videoURL;
		this.channel = channel;
	}


	

	public Video(int videoId, String videoname, float videolength, int videolikes, int videodislikes,
			String videodescription, String videoURL, Channel channel) {
		super();
		this.videoId = videoId;
		this.videoname = videoname;
		this.videolength = videolength;
		this.videolikes = videolikes;
		this.videodislikes = videodislikes;
		this.videodescription = videodescription;
		this.videoURL = videoURL;
		this.channel = channel;
	}



	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

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

	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result + videoId;
		result = prime * result + ((videoURL == null) ? 0 : videoURL.hashCode());
		result = prime * result + ((videodescription == null) ? 0 : videodescription.hashCode());
		result = prime * result + Float.floatToIntBits(videodislikes);
		result = prime * result + Float.floatToIntBits(videolength);
		result = prime * result + Float.floatToIntBits(videolikes);
		result = prime * result + ((videoname == null) ? 0 : videoname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Video other = (Video) obj;
		if (channel == null) {
			if (other.channel != null)
				return false;
		} else if (!channel.equals(other.channel))
			return false;
		if (videoId != other.videoId)
			return false;
		if (videoURL == null) {
			if (other.videoURL != null)
				return false;
		} else if (!videoURL.equals(other.videoURL))
			return false;
		if (videodescription == null) {
			if (other.videodescription != null)
				return false;
		} else if (!videodescription.equals(other.videodescription))
			return false;
		if (Float.floatToIntBits(videodislikes) != Float.floatToIntBits(other.videodislikes))
			return false;
		if (Float.floatToIntBits(videolength) != Float.floatToIntBits(other.videolength))
			return false;
		if (Float.floatToIntBits(videolikes) != Float.floatToIntBits(other.videolikes))
			return false;
		if (videoname == null) {
			if (other.videoname != null)
				return false;
		} else if (!videoname.equals(other.videoname))
			return false;
		return true;
	}
	
	
	
}
