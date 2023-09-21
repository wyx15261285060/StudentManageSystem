package com.edu.njit.stusystem.dao.mapper;

import java.sql.ResultSet;

import com.edu.njit.stusystem.pojo.Student;
import com.edu.njit.stusystem.util.ResultMapper;

public class StuMapper implements ResultMapper{
	
	@Override
	public Object mapper(ResultSet rs) throws Exception {
		//指定当前查询的表和实体类的映射关系
		int num = rs.getInt("num");
		String name = rs.getString("name");
		int age = rs.getInt("age");
		String phone = rs.getString("phone");
		String address = rs.getString("address");
		Student s = new Student(num,name,age,phone,address);
		return s;
	}


}
