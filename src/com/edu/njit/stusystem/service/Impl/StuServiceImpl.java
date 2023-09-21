package com.edu.njit.stusystem.service.Impl;

import java.util.List;

import com.edu.njit.stusystem.dao.StuDao;
import com.edu.njit.stusystem.pojo.Student;
import com.edu.njit.stusystem.dao.Impl.StuDaoImpl;
import com.edu.njit.stusystem.exception.StuException;
import com.edu.njit.stusystem.service.StuService;

public class StuServiceImpl implements StuService {
	private StuDao stuDao = new StuDaoImpl();
	
	/*
	 * 添加一个学生
	 * 业务逻辑
	 */
	public void addStu(Student stu) throws StuException{
		Student s = stuDao.findById(stu.getNum());
		if(s != null) {
			throw new StuException("该学号无法使用") ;
		}
		
		//添加学生
		stuDao.insert(stu);
	}
	
	
	/*
	 * 删除一个学生的信息
	 */
	public void delStu(int num) throws StuException{
		Student s = stuDao.findById(num);
		if(s == null) {
			throw new StuException("查无此人！");
		}
		stuDao.delete(num);
		
	}
	
	/*
	 * 根据学生的学号来查询学生信息
	 */
	public Student findById(int num) throws StuException{
		Student s = stuDao.findById(num);
		if(s == null) {
			StuException e  = new StuException("查无此人！");
			throw e;
		}
		return s;
		
	}
	/*
	 * 
	 */
	public List<Student> findAllStus() {
		return stuDao.findStu();
	}
}
