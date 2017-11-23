package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.mysql.jdbc.PreparedStatement;

public class DBconn{
	 static String url="jdbc:mysql://localhost:3306/text? useUnicude=true &amp;characterEncoding=utf8&amp;"
	 		+ "autoReconnect=true&amp;failOverReadOnly=false";
	 static String name="zhang";
	 static String password="zhang";
	 static Connection conn=null;
	 static PreparedStatement ps=null;//Ԥ����
	 static ResultSet rs=null;//����һ�����ݼ���
	 public static void init(){
		 try{
			 Class.forName("com.mysql.jdbc.Driver");//��������
			 conn=DriverManager.getConnection(url,name,password);
	 }catch(ClassNotFoundException e){
		 System.out.println("���ݿ����������쳣!");
		 e.printStackTrace();
	 }catch(SQLException e){
		 System.out.println("���ݿ������쳣!");
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
			// TODO �Զ����ɵ� catch ��
			System.out.println("���ݿ�����쳣");
			e.printStackTrace();
		}
		 return executeUpdate;//���ؽ�������Ӱ�������
	 }
	 public static PreparedStatement getPreparedStatement(String sql){ //��ȡԤ����  
	        try {  
	            ps= conn.prepareStatement(sql);  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        return ps;  
	    }  
	 public static ResultSet sqlSelect(String sql){
		 try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			System.out.println("���ݿ��ѯ�쳣");
			e.printStackTrace();
		}
		 return rs;
	 }
	 public static void sqlClose(){
		 try {
			conn.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			System.out.println("���ݿ�ر��쳣");
			e.printStackTrace();
		}
	 }
}


