package com.edu.njit.stusystem.service;

import java.util.List;

import com.edu.njit.stusystem.exception.StuException;
import com.edu.njit.stusystem.pojo.Student;

public interface StuService {
	
	void addStu (Student stu) throws StuException;

	void delStu(int num) throws StuException;

	List<Student> findAllStus() ;
	
	Student findById(int num)throws StuException;

}
