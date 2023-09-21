package com.edu.njit.stusystem.dao;

import java.util.List;

import com.edu.njit.stusystem.pojo.User;

public interface UserDao {
	
	/*
	 * 注册用户
	 */
	
	User selectByUserName(String userName);
	
	void insertUser(User user);	
	

}
