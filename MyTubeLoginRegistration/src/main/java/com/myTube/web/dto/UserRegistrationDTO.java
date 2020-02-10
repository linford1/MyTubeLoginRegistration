package com.myTube.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class UserRegistrationDTO {
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String userpassword;
	
	@Email
	@NotEmpty
	private String useremail;

	@Email
	@NotEmpty
	private String confirmuseremail;
	
	@NotEmpty
	private String firstname;
	
	@NotEmpty
	private String lastname;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getConfirmuseremail() {
		return confirmuseremail;
	}

	public void setConfirmuseremail(String confirmuseremail) {
		this.confirmuseremail = confirmuseremail;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	
}
