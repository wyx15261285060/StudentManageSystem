package com.edu.njit.stusystem.pojo;

public class User {

	String userName;
	
	String passWord;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", passWord=" + passWord + "]";
	}

	public User(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	

}
