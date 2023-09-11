package com.edu.njit.stusystem.service;

import com.edu.njit.stusystem.exception.UserException;
import com.edu.njit.stusystem.pojo.User;

public interface UserService {
	
	void regist(User user,String repassword) throws UserException;
	
	
	void login(User user) throws UserException;
	
	

}
