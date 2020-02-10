package com.myTube.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserAccount")
public class User {
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Column(name="User_Name",unique=true)
	private String username;
	
	@Column(name="User_Password")
	private String userpassword;
	
	@Column(name="User_Email",unique=true)
	private String useremail;
	
	@Column(name="First_Name")
	private String firstname;
	
	@Column(name="Last_Name")
	private String lastname;
	
	@Column(name="AccountCreationDate")
	private String accountcreationdate;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	public String getAccountcreationdate() {
		return accountcreationdate;
	}

	public void setAccountcreationdate(String accountcreationdate) {
		this.accountcreationdate = accountcreationdate;
	}

	public User()
	{
		
	}
	
	public User(int userId, String username, String userpassword, String useremail, String firstname, String lastname,
			String accountcreationdate) {
		super();
		this.userId = userId;
		this.username = username;
		this.userpassword = userpassword;
		this.useremail = useremail;
		this.firstname = firstname;
		this.lastname = lastname;
		this.accountcreationdate = accountcreationdate;
	}

	public User(String username, String userpassword, String useremail, String firstname, String lastname,
			String accountcreationdate) {
		super();
		this.username = username;
		this.userpassword = userpassword;
		this.useremail = useremail;
		this.firstname = firstname;
		this.lastname = lastname;
		this.accountcreationdate = accountcreationdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountcreationdate == null) ? 0 : accountcreationdate.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + userId;
		result = prime * result + ((useremail == null) ? 0 : useremail.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((userpassword == null) ? 0 : userpassword.hashCode());
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
		User other = (User) obj;
		if (accountcreationdate == null) {
			if (other.accountcreationdate != null)
				return false;
		} else if (!accountcreationdate.equals(other.accountcreationdate))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (userId != other.userId)
			return false;
		if (useremail == null) {
			if (other.useremail != null)
				return false;
		} else if (!useremail.equals(other.useremail))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (userpassword == null) {
			if (other.userpassword != null)
				return false;
		} else if (!userpassword.equals(other.userpassword))
			return false;
		return true;
	}
	
	
}
