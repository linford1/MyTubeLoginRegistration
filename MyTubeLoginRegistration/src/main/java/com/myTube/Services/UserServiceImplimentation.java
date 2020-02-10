package com.myTube.Services;


import com.myTube.Entities.User;
import com.myTube.web.dto.UserLogInDTO;
import com.myTube.web.dto.UserRegistrationDTO;

public class UserServiceImplimentation {

	public User createUserObject(UserRegistrationDTO registration)
	{
		User user = new User();
		
		user.setFirstname(registration.getFirstname());
		user.setLastname(registration.getFirstname());
		user.setUseremail(registration.getUseremail());
		user.setUserpassword(registration.getUserpassword());
		user.setUsername(registration.getUsername());
		return user;
	}
	
	public User createUserObject(UserLogInDTO registration)
	{
		User user = new User();
		
		user.setUserpassword(registration.getUserpassword());
		user.setUsername(registration.getUsername());
		
		return user;
	}
}
