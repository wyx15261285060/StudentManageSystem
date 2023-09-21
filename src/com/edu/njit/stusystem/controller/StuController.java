package com.edu.njit.stusystem.controller;

import java.util.List;
import java.util.Scanner;

import com.edu.njit.stusystem.exception.StuException;
import com.edu.njit.stusystem.pojo.Student;
import com.edu.njit.stusystem.service.StuService;
import com.edu.njit.stusystem.service.Impl.StuServiceImpl;


public class StuController {
	private StuService stuService = new StuServiceImpl();
	private Scanner sc = new Scanner(System.in);
	public void addStu() {
		System.out.println("请输入学号: ");
		int num = sc.nextInt();
		System.out.println("请输入姓名: ");
		String name = sc.next();
		System.out.println("请输入年龄: ");
		int age = sc.nextInt();
		System.out.println("请输入电话: ");
		String phone = sc.next();
		System.out.println("请输入地址: ");
		String address = sc.next();
		Student stu = new Student(num,name, age, phone, address);
		try {
			stuService.addStu(stu);
			System.out.println("添加成功！");
		}catch(StuException e) {
			System.out.println(e.getMessage());
		}
	}

	public void delStu() {
		System.out.println("请输入需要删除学生的学号: ");
		int num = sc.nextInt();
		try {
			stuService.delStu(num);
			System.out.println("删除成功");
		}catch(StuException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void findById() {
		System.out.println("请输入需要查询学生的学号: ");
		int num = sc.nextInt();
		try {
			Student stu = stuService.findById(num);
			System.out.println("学号："+ num+"  姓名：" + stu.getName()+"  年龄:" + stu.getAge()
			+ "  电话:" + stu.getPhone() + "  地址:" + stu.getAddress());
		}catch(StuException e) {
			System.out.println(e.getMessage());
		}
	}

	public void findAllStus() {
		List<Student> stus = stuService.findAllStus();
		for (int i = 0; i < stus.size(); i++) {
			if (stus.get(i) != null) {
				System.out.println("学号:" + stus.get(i).getNum() + 
								   "  姓名:" + stus.get(i).getName() +
								   "  年龄:" + stus.get(i).getAge() + 
								   "  电话:" + stus.get(i).getPhone() +
								   "  地址:" + stus.get(i).getAddress());
			}
		}

	}

	public void run() {
		boolean flag = true;
		while (flag) {
			int chooice = printMenu();
			switch (chooice) {
			case 1:
				findAllStus();
				break;
			case 2:
				addStu();
				break;
			case 3:
				delStu();
				break;
			case 4:
				findById();
				break;
			case 5:
				System.out.println("谢谢使用");
				flag = false;
				break;
			default:
				System.out.println("请选择正确的选项");
			}
		}
	}

	/**
	 * 展示学生系统的菜单
	 */
	public int printMenu() {
		System.out.println("--学生系统--");
		System.out.println("1.查看学生信息");
		System.out.println("2.添加学生");
		System.out.println("3.删除学生");
		System.out.println("4.输入学生id查询学生信息");
		System.out.println("5.退出系统");
		System.out.println("请选择:");
		// 此处需要用户在控制台输入对应的选项
		int chooice = sc.nextInt();
		return chooice;
	}

}
