package com.wsft.excel.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wsft.excel.domain.Vegetable;

public class DbUtil {

	//public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_NAME = "vegemarket";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "root";
	//public static final String IP = "112.33.253.33";
	public static final String IP = "localhost";
	public static final String PORT = "3306";
	public static final String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DB_NAME;
	//public static final String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DB_NAME +"?serverTimezone=GMT";
	public static void insert(String sql, Vegetable vegetable) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = conn.prepareStatement(sql);
			//ps.setInt(1, vegetable.getId());
			ps.setDate(1, vegetable.getTesttm());
			ps.setString(2, vegetable.getManage());
			ps.setString(3, vegetable.getSampName());
			ps.setString(4, vegetable.getLocation());
			ps.setString(5, vegetable.getChannels());
			ps.setFloat(6, vegetable.getTestidx());
			ps.setString(7, vegetable.getResult());
			ps.setString(8, vegetable.getTestaddr());
			boolean flag = ps.execute();
			if(!flag){
				System.out.println("Save data : succeed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List selectOne(String sql, Vegetable vegetable) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getString("manage").equals(vegetable.getManage())|| rs.getString("sampname").equals(vegetable.getSampName())
				|| rs.getString("testaddr").equals(vegetable.getTestaddr())|| rs.getString("testtm").equals(vegetable.getTesttm())){
					list.add(1);
				}else{
					list.add(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}
	
	
	public static ResultSet selectAll(String sql) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return rs;
	}
}
