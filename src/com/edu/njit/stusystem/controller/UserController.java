package com.edu.njit.stusystem.controller;

import java.util.Scanner;

import com.edu.njit.stusystem.exception.UserException;
import com.edu.njit.stusystem.pojo.User;
import com.edu.njit.stusystem.service.UserService;
import com.edu.njit.stusystem.service.Impl.UserServiceImpl;

public class UserController {
	
	private UserService userService = new UserServiceImpl();
	private Scanner sc = new Scanner(System.in);
			
	/*
	 * 展示用户登录注册的菜单，返回用户输入的选项
	 */
	public int printMenu() {
		System.out.println("--注册登录--");
		System.out.println("1. 注册");
		System.out.println("2. 登录");
		System.out.println("请选择：");
		int chooice = sc.nextInt();
		return chooice;
	}
	
	public void run() {
		boolean flag = true;
		while(flag) {
			int chooice = printMenu();
			switch(chooice) {
			case 1://注册
				regist();
				break;
			case 2://登录
				//登录
				//登录成功循环结束(flag = false)
				//登陆失败继续展示菜单
				flag = !login();
				
				break;
				
			default:
				System.out.println("请输入正确的学号");
			}
			
		}
		
	}
	
	public void regist() {
		System.out.println("请输入userName： ");
		String userName = sc.next();
		System.out.println("请输入passWord: ");
		String passWord = sc.next();
		System.out.println("请确认密码： ");
		String repassword = sc.next();
		User user = new User(userName,passWord);
		try {
			userService.regist(user, repassword);
			System.out.println("注册成功");
		}catch(UserException e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public boolean login() {
		System.out.println("请输入userName： ");
		String userName = sc.next();
		System.out.println("请输入passWord: ");
		String passWord = sc.next();
		User user = new User(userName,passWord);
//		boolean isLogin = userService.login(user);
		try {
			userService.login(user);
			System.out.println("登录成功");
			return true;
			
		}catch(UserException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	

}
