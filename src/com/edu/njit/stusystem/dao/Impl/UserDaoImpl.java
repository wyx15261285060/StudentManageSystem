package com.edu.njit.stusystem.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import com.edu.njit.stusystem.dao.UserDao;
import com.edu.njit.stusystem.pojo.User;

public class UserDaoImpl implements UserDao{
	
	private static List<User> users = new ArrayList<User>();
	

	@Override
	//每次执行insertUser方法之后index会自动增加
	public void insertUser(User user) {
		users.add(user);
	}

	
	@Override
	public User selectByUserName(String userName) {
		for(int i = 0;i<users.size();i++) {
			if(users.get(i) != null && users.get(i).getUserName().equals(userName)) {
				return users.get(i);
			}
		}
		// TODO Auto-generated method stub
		return null;
	}


		

}
