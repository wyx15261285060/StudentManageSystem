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

import com.edu.njit.stusystem.exception.StuException;
import com.edu.njit.stusystem.exception.UserException;
import com.edu.njit.stusystem.pojo.Student;
import com.edu.njit.stusystem.pojo.User;
import com.edu.njit.stusystem.service.StuService;
import com.edu.njit.stusystem.service.Impl.StuServiceImpl;

public class StuAddFrame extends JFrame {

	private JPanel contentPane;
	
	private JTextField textField;
	
	private JTextField textField_1;
	
	private JTextField textField_2;
	
	private JTextField textField_3;
	
	private JTextField textField_4;
	
	private StuService stuService = new StuServiceImpl();

	public StuAddFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口的标题
		setTitle("学生管理-添加");
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
		textField.setFont(new Font("宋体", Font.PLAIN, 30));
		//设置该对象的位置和大小
		textField.setBounds(500, 100, 420, 70);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 30));
		textField_1.setBounds(500, 200, 420, 70);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 30));
		textField_2.setBounds(500, 300, 420, 70);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 30));
		textField_3.setBounds(500, 400, 420, 70);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 30));
		textField_4.setBounds(500, 500, 420, 70);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		//创建文字标签对象
		JLabel label = new JLabel("学号：");
		label.setFont(new Font("宋体", Font.PLAIN, 34));
		label.setBounds(267, 122, 150, 29);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("姓名：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 34));
		label_1.setBounds(267, 222, 108, 29);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("年龄：");
		label_2.setFont(new Font("宋体", Font.PLAIN, 34));
		label_2.setBounds(267, 322, 170, 29);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("电话：");
		label_3.setFont(new Font("宋体", Font.PLAIN, 34));
		label_3.setBounds(267, 422, 170, 29);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("地址：");
		label_4.setFont(new Font("宋体", Font.PLAIN, 34));
		label_4.setBounds(267, 522, 170, 29);
		contentPane.add(label_4);
		
		//创建了一个按钮对象
		JButton button = new JButton("确认");
		//指定点击当前按钮需要做的事情
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//获取用户输入的信息
				int num = Integer.parseInt(textField.getText());
				String name = textField_1.getText();
				int age = Integer.parseInt(textField_2.getText());
				String phone = textField_3.getText();
				String address = textField_4.getText();
				Student s = new Student(num,name,age,phone,address);
				try {
					stuService.addStu(s);
					dispose();
					StuListFrame frame = new StuListFrame();
					frame.setVisible(true);
				} catch (StuException e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage());
				}
				
			}
		});
		//设置字体
		button.setFont(new Font("宋体", Font.PLAIN, 30));
		//设置对象的存放位置
		button.setBounds(720, 668, 200, 50);
		contentPane.add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StuListFrame frame = new StuListFrame();
				frame.setVisible(true);
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 30));
		button_1.setBounds(267, 668, 200, 50);
		contentPane.add(button_1);
	}

}
