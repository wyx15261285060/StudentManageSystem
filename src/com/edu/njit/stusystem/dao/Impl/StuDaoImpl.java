package com.edu.njit.stusystem.dao.Impl;

import java.util.List;

import com.edu.njit.stusystem.dao.StuDao;
import com.edu.njit.stusystem.dao.mapper.StuMapper;
import com.edu.njit.stusystem.pojo.Student;
import com.edu.njit.stusystem.util.JDBCTemplate;

public class StuDaoImpl implements StuDao {
	/*
	 * 声明一个静态数组来存储数据 数据的处理
	 */
	private JDBCTemplate jdbcTemplate = new JDBCTemplate();


	/*
	 * 查询学生信息
	 */
	public List<Student> findStu() {
		String sql = "select * from stu";
		return (List<Student>) jdbcTemplate.query(sql, null, new StuMapper());

	}

	/*
	 * 添加一个学生信息
	 */
	public void insert(Student stu) {
		String sql = "insert into" + " stu(num,name,age,phone,address)" + " values(?,?,?,?,?)";
		jdbcTemplate.update(sql,
				new Object[] { stu.getNum(), stu.getName(), stu.getAge(), stu.getPhone(), stu.getAddress() });
	}

	/*
	 * 删除一个学生信息
	 */
	public void delete(int num) {
		String sql = " delete from stu where num = ? ";
		jdbcTemplate.update(sql, new Object[] { num });
	}

	/*
	 * 根据学生学号来查询单个学生信息
	 */
	@Override
	public Student findById(int num) {
		String sql = "select * from stu where num = ?";
		return (Student) jdbcTemplate.queryObject(sql, new Object[] { num }, new StuMapper());
	}

}
