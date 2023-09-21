package com.edu.njit.stusystem.dao.mapper;

import java.sql.ResultSet;

import com.edu.njit.stusystem.pojo.User;
import com.edu.njit.stusystem.util.ResultMapper;

public class UserMapper implements ResultMapper {

	@Override
	public Object mapper(ResultSet rs) throws Exception {
		String userName = rs.getString("user_name");
		String password = rs.getString("password");
		User u = new User(userName,password);
		return u;
	}

}
