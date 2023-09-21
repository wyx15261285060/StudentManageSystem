package com.edu.njit.stusystem.dao;

import java.util.List;

import com.edu.njit.stusystem.pojo.Student;

public interface StuDao {

	/*
	 * 查询学生信息
	 */
	List<Student> findStu();

	/*
	 * 添加学生
	 */
	void insert(Student stu);
	/*
	 * 删除学生
	 */

	void delete(int num);
	/*
	 * 根据学号来查询学生信息
	 */
	Student findById(int num);
	

}
