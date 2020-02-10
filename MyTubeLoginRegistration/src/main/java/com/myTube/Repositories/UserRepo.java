package com.myTube.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myTube.Entities.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>
{
	
	User findByUseremail(String useremail);
	User findByUsername(String username);
	User findByUsernameAndUserpassword(String username, String userpassword);
}
					