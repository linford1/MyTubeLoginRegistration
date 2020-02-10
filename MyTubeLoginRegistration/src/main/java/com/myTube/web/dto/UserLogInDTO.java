package com.myTube.web.dto;

import javax.validation.constraints.NotEmpty;

public class UserLogInDTO  {
	
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String Userpassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return Userpassword;
	}

	public void setUserpassword(String userpassword) {
		Userpassword = userpassword;
	}
	

}
