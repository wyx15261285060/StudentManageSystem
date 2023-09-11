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
public class RegistFrame extends JFrame {
	private UserService userService = new UserServiceImpl();

	private JPanel contentPane;
	
	private JTextField textField;
	
	private JTextField textField_1;
	
	private JTextField textField_2;

	public RegistFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口的标题
		setTitle("注册");
		//设置窗口弹出的位置 以及窗口的大小
		setBounds(500, 300, 1200, 900);
		//设置面板
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//创建文本框对象
		textField = new JTextField();
		//设置文本框中的字体样式
		textField.setFont(new Font("楷体", Font.PLAIN, 30));
		//设置该对象的位置和大小
		textField.setBounds(500, 150, 420, 70);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("楷体", Font.PLAIN, 30));
		textField_1.setBounds(500, 250, 420, 70);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("楷体", Font.PLAIN, 30));
		textField_2.setBounds(500, 350, 420, 70);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		//创建文字标签对象
		JLabel label = new JLabel("用户名：");
		label.setFont(new Font("楷体", Font.PLAIN, 34));
		label.setBounds(267, 172, 150, 29);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("密码：");
		label_1.setFont(new Font("楷体", Font.PLAIN, 34));
		label_1.setBounds(267, 272, 108, 29);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("确认密码：");
		label_2.setFont(new Font("楷体", Font.PLAIN, 34));
		label_2.setBounds(267, 372, 170, 29);
		contentPane.add(label_2);
		
		//创建了一个按钮对象
		JButton button = new JButton("确认");
		//指定点击当前按钮需要做的事情
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String loginName = textField.getText();
				String password = textField_1.getText();
				String repassword = textField_2.getText();
				User user = new User(loginName,password);
				try {
					userService.regist(user, repassword);
					dispose();
					LoginFrame f = new LoginFrame();
					f.setVisible(true);
				} catch (UserException e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage());
				}
				
			}
		});
		//设置字体
		button.setFont(new Font("楷体", Font.PLAIN, 30));
		//设置对象的存放位置
		button.setBounds(720, 535, 200, 50);
		contentPane.add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame f = new LoginFrame();
				f.setVisible(true);
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 30));
		button_1.setBounds(267, 535, 200, 50);
		contentPane.add(button_1);
	}

}
