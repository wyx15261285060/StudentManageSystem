package com.edu.njit.stusystem.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {

	/*
	 * private static String url = "jdbc:mysql://localhost:3306/stusystem"+
	 * "?userunicode=true&characterEncoding=utf-8";
	 * 
	 * private static String username = "root";
	 * 
	 * private static String password = "123456";
	 */
	private static Properties p = new Properties();
	/*
	 * 获取 连接对象
	 */
	static {
		try {
			InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("datasources.properties");
			p.load(is);
			System.out.println(p);

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
	}

	/*
	 * 关闭资源
	 */
	public static void close(ResultSet rs, Statement state, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (state != null) {
				state.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
