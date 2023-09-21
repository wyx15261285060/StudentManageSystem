package com.edu.njit.stusystem.dao.Impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.edu.njit.stusystem.dao.UserDao;
import com.edu.njit.stusystem.dao.mapper.UserMapper;
import com.edu.njit.stusystem.pojo.User;
import com.edu.njit.stusystem.util.FileUtil;
import com.edu.njit.stusystem.util.JDBCTemplate;

public class UserDaoImpl implements UserDao{
	
//	private static List<User> users = new ArrayList<User>();
//	private static File file = new File("D:\\Files\\Java_Files\\users.txt");
	private JDBCTemplate jdbcTemplate = new JDBCTemplate();
	
	@Override
	//每次执行insertUser方法之后index会自动增加
	//将改变后的集合更新到本地文件中
	public void insertUser(User user) {
		String sql = "insert into user(user_name,password)"
				+ "values(?,?)";
		jdbcTemplate.update(sql, new Object[] {
				user.getUserName(),
				user.getPassword()
		});
		
	}

	
	@Override
	public User selectByUserName(String userName) {
		String sql = "select * from user where user_name = ?";
		return (User)jdbcTemplate.queryObject(sql, 
				new Object[] {userName},
				new UserMapper());
	}


		

}
