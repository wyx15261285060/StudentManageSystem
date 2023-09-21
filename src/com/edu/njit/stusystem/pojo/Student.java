package com.edu.njit.stusystem.pojo;

import java.io.Serializable;

public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int num;
	
	private String name;
	
	private int age;
	
	private String phone;
	
	private String address;
	
	public Student() {
		
	}
	public Student(String name,int age,String phone,String address) {

		
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}
	
	
	/*
	 * 封装，提供get和set方法
	 */

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public Student(int num, String name,int age,String phone,String address) {

		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	
	
}
