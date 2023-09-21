package com.edu.njit.stusystem.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.njit.stusystem.pojo.User;
/**
 * JDBC操作数据库模板
 * @author wyx
 *
 */
public class JDBCTemplate {
	
	/*
	 * 更新数据的模板
	 * 包括了增删改
	 */
	public void update(String sql,Object[] params) {
		Connection con = null;
		PreparedStatement state = null;
		try {
			con = JDBCUtil.getConnection();
			state = con.prepareStatement(sql);
			//给?赋值
			if(params != null) {
				for(int i = 0;i < params.length;i++) {
					state.setObject(i+1, params[i]);
				}
			}
			state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, state, con);
		}
	}
	
	/*
	 * 查询数据的模板
	 */
	public List query(String sql,Object[] params,ResultMapper rm) {
		Connection con = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			con = JDBCUtil.getConnection();
			state = con.prepareStatement(sql);
			//给?赋值
			if(params != null) {
				for(int i = 0;i < params.length;i++) {
					state.setObject(i+1, params[i]);
				}
			}
			rs = state.executeQuery();
			while(rs.next()) {
				Object object = rm.mapper(rs);
				list.add(object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, state, con);
		}
		return list;
	}
	
	public Object queryObject(String sql,Object[] params,ResultMapper rm) {
		List list = query(sql,params,rm);
		return list.isEmpty() ? null : list.get(0);
	}
	

}
