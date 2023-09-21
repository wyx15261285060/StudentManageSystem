package com.edu.njit.stusystem.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import com.edu.njit.stusystem.exception.StuException;
import com.edu.njit.stusystem.pojo.Student;
import com.edu.njit.stusystem.service.StuService;
import com.edu.njit.stusystem.service.Impl.StuServiceImpl;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StuListFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private StuService stuService = new StuServiceImpl();
	
	public StuListFrame() {
		setTitle("学生管理-列表");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 1700, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("添加学生");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				StuAddFrame frame = new StuAddFrame();
				frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 30));
		btnNewButton.setBounds(1403, 74, 228, 61);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("删除学生");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//获取选中的行
				int row = table.getSelectedRow();
				//获取该行的第一列数据
				int num = (Integer)table.getValueAt(row, 0);
				try {
					stuService.delStu(num);
					//刷新表格中的数据
					initTable();
				} catch (StuException e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage());
				}
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 30));
		button.setBounds(1403, 200, 228, 61);
		contentPane.add(button);
		
		JButton button_1 = new JButton("退出系统");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//关闭当前页面
				dispose();
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 30));
		button_1.setBounds(1403, 755, 228, 61);
		contentPane.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(584, 172, 2, 2);
		contentPane.add(scrollPane);
		
		
		//创建一个滚动条面板对象 存放到主面板中
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 21, 1320, 887);
		contentPane.add(scrollPane_1);
		
		//创建了一个表格对象存放在滚动条面板的右下角
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		//设置表格的样式
		table.setRowHeight(80);
		table.setFont(new Font("宋体", Font.PLAIN, 40));
		
		//从表格中获取表头
		JTableHeader tableHeader = table.getTableHeader();
		//设置表头的行高 第二个参数指定行高
		tableHeader.setPreferredSize(new Dimension(1, 80));
		tableHeader.setFont(new Font("宋体", Font.PLAIN, 40));
		tableHeader.setBackground(Color.pink);
		
		initTable();
		
		
	}
	
	public void initTable() {
		//定义表头数据
				String[] headers = {"学号","姓名","年龄","电话","地址"};
				//获取表格中的数据
				List<Student> stus = stuService.findAllStus();
				//将集合中的数据转换成二维数组
				Object[][] datas = new Object[stus.size()][5];
				for(int i = 0;i < stus.size();i++) {
					datas[i][0] = stus.get(i).getNum();
					datas[i][1] = stus.get(i).getName();
					datas[i][2] = stus.get(i).getAge();
					datas[i][3] = stus.get(i).getPhone();
					datas[i][4] = stus.get(i).getAddress();
				}
				//将表头和数据定义为模型存放到表格对象中
				DefaultTableModel model = new DefaultTableModel(datas,headers);
				table.setModel(model);
	}
}
