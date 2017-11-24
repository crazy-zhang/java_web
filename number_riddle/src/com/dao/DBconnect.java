package com.dao;
import java.sql.*;

public class DBconnect {
	static String url="jdbc:mysql://localhost:3306/number_riddle? useUnicude=true &amp;characterEncoding=utf8&amp;"+
 "autoReconnect=true&amp; failOverReadOnly=false";
	static String name="zhang";
	static String password="zhang";
	static Connection conn=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	public static void init(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,name,password);
		}catch(ClassNotFoundException e){
			System.out.println("数据库驱动加载异常");
			e.printStackTrace();
		}catch(SQLException e){
			System.out.println("数据库连接异常");
			e.printStackTrace();
		}
	}
	public static 	int addDeleteUpdate(String sql){
		int execute_update=0;
		try{
			ps=conn.prepareStatement(sql);
			execute_update=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return execute_update;
	}
	public static ResultSet sqlQuery(String sql){
		try{
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	public static void sqlClosed(){
		try{
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
















