package com.edu.njit.stusystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.edu.njit.stusystem.exception.UserException;
import com.edu.njit.stusystem.pojo.User;
import com.edu.njit.stusystem.service.UserService;
import com.edu.njit.stusystem.service.Impl.UserServiceImpl;

public class LoginFrame extends JFrame {

	/*
	 * 定义一个登录窗口类
	 * Jpanel窗口面板
	 */
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	private UserService userService = new UserServiceImpl();

	/*
	 * 定义当前窗口中的面板
	 */
	
	private JTextField textField;
	
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("用户登录界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口弹出的位置以及窗口的大小
		setBounds(400, 300, 1200, 800);
		//设置面板
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		//创建一个窗口对象
//		LoginFrame frame = new LoginFrame();
//		frame.getContentPane().setLayout(null);
		//创建文本框对象
		textField = new JTextField();
		textField.setFont(new Font("楷体", Font.PLAIN, 30));
		textField.setBounds(400, 150, 420, 70);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("楷体", Font.PLAIN, 30));
		textField_1.setBounds(400, 300, 420, 70);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		//创建文字标签对象
		JLabel label = new JLabel("用户名:");
		label.setFont(new Font("楷体", Font.PLAIN, 30));
		label.setBounds(167, 172, 150, 29);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("密码:");
		label_1.setFont(new Font("楷体", Font.PLAIN, 30));
		label_1.setBounds(167, 322, 108, 29);
		contentPane.add(label_1);
		
		//创建了一个按钮对象
		JButton button = new JButton("登录");
		//指定点击当前按钮需要做的事情
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//获取用户在文本框中输入的信息
				String userName = textField.getText();
				String password = textField_1.getText();
				User user = new User(userName,password);
				try {
					userService.login(user);
					//跳转到学生系统的首页
					StuListFrame frame = new StuListFrame();
					frame.setVisible(true);
				} catch (UserException e) {
					//将指定的信息在指定的面板中弹出
					JOptionPane.showMessageDialog(contentPane, e.getMessage());
				}
			}
		});
		//设置字体
		button.setFont(new Font("宋体", Font.PLAIN, 30));
		//设置对象的存放位置
		button.setBounds(620, 537, 200, 50);
		contentPane.add(button);
		
		JButton button_1 = new JButton("注册");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//关闭当前窗口
				dispose();
				//打开注册窗口
				RegistFrame f = new RegistFrame();
				f.setVisible(true);
				
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 30));
		button_1.setBounds(167, 537, 200, 50);
		contentPane.add(button_1);
		
		
		
	}

}
