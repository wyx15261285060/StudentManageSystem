package com.edu.njit.stusystem.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import com.edu.njit.stusystem.dao.StuDao;
import com.edu.njit.stusystem.pojo.Student;

public class StuDaoImpl implements StuDao{
	/*
	 * 声明一个静态数组来存储数据
	 * 数据的处理
	 */
	private static List<Student> stus = new ArrayList<Student>();
	static {
		//创建一批数据
		Student s1 = new Student(1,"wyx",18,"123","njit");
		Student s2 = new Student(2,"xyd",18,"321","ciot");
		stus.add(s1);
		stus.add(s2);
	}
	
	/*
	 * 查询学生信息
	 */
	public List<Student> findStu() {
		return stus;
	}
	
	/*
	 * 添加一个学生信息
	 */
	public void insert(Student stu) {
		stus.add(stu);
	}
	
	/*
	 * 删除一个学生信息
	 */
	public void delete(int num) {
		for(int i = 0;i < stus.size();i++) {
			if(stus.get(i).getNum() == num) {
				stus.remove(i);
			}
		}
	}
	/*
	 * 根据学生学号来查询单个学生信息
	 */
	public Student findById(int num) {
		for(int i = 0;i < stus.size();i++) {
			if(stus.get(i).getNum() == num) {
				return stus.get(i);
			}	
		}
		return null;
		
	}

}
