package com.dao;

import java.sql.*;

//import com.mysql.jdbc.PreparedStatement;

public class DBconnect{
	 static String url="jbdc:mysql://localhost:3306/text? useUnicude=true &amp;characterEncoding=utf8&amp;"
	 		+ "autoReconnect=true&amp;failOverReadOnly=false";
	 static String name="zhang";
	 static String password="zhang";
	 static Connection conn=null;
	 static PreparedStatement ps=null;//预加载
	 static ResultSet rs=null;//返回一个数据集合
	 public static void init(){
		 try{
			 Class.forName("com.mysql.jbdc.Driver");//加载驱动
			 conn=DriverManager.getConnection(url,name,password);
	 }catch(ClassNotFoundException e){
		 System.out.println("数据库驱动加载异常!");
		 e.printStackTrace();
	 }catch(SQLException e){
		 System.out.println("数据库连接异常!");
		 e.printStackTrace();
	 } 
}
	 public static int addDeleteUpdate(String sql){
		 int executeUpdate=0;
		 try {
			ps=conn.prepareStatement(sql);
			executeUpdate=ps.executeUpdate();
			return executeUpdate;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("数据库更新异常");
			e.printStackTrace();
		}
		 return executeUpdate;//返回结果最后受影响的行数
	 }
	 public static ResultSet sqlSelect(String sql){
		 try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("数据库查询异常");
			e.printStackTrace();
		}
		 return rs;
	 }
	 public static void sqlClose(){
		 try {
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("数据库关闭异常");
			e.printStackTrace();
		}
	 }
}
















