package com.edu.njit.stusystem.service.Impl;

import com.edu.njit.stusystem.dao.UserDao;
import com.edu.njit.stusystem.dao.Impl.UserDaoImpl;
import com.edu.njit.stusystem.exception.UserException;
import com.edu.njit.stusystem.pojo.User;
import com.edu.njit.stusystem.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao = new UserDaoImpl();
	//注册功能的业务逻辑层
	public void regist(User user,String repassword) throws UserException{
		// TODO Auto-generated method stub
		
		//判断两次是否一致
		if(!user.getPassWord().equals(repassword)) {
			UserException e =new UserException("两次密码不一致");
			throw e;
		}
		//判断用户名是否已注册
		User u = userDao.selectByUserName(user.getUserName());

		if(u!= null) {
			UserException e = new UserException("用户已注册，请直接登录： ");
			throw e;
		}
		
		userDao.insertUser(user);
	}
	
	//登录功能的业务逻辑层
	@Override
	public void login(User user) throws UserException {
		// TODO Auto-generated method stub
		User u = userDao.selectByUserName(user.getUserName());
		if(u == null || !u.getPassWord().equals(user.getPassWord())) {
			UserException e = new UserException("用户名或密码错误！");
			throw e;
			
		}
	}
}
