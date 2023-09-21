package com.edu.njit.stusystem.pojo;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	String userName;
	
	String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public User() {
	
		// TODO Auto-generated constructor stub
	}
	

	

}
