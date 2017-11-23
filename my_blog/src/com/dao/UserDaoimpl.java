package com.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;
import com.util.DBconn;

public class UserDaoimpl implements UserDao{

	@Override
	public boolean login(String name, String pwd) {
		// TODO 自动生成的方法存根
		boolean flag=false;
		try{
			DBconn.init();
			ResultSet rs=DBconn.sqlSelect("select * from user where name='"+name+"' and pwd='"+pwd+"'");
			while(rs.next()){
				if(rs.getString("name").equals(name)&&rs.getString("pwd").equals(pwd)){
					flag=true;
				}
			}
			DBconn.sqlClose();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean regist(User user) {
		// TODO 自动生成的方法存根
		boolean flag=false;
		DBconn.init();
		int executeDate=DBconn.addDeleteUpdate("insert into user(name,pwd,sex,home,info)"+
				"values('"+user.GetName()+"','"+user.GetPwd()+"','"+user.GetSex()+"','"+user.GetHome()+"','"+user.GetInfo()+"')");
		if(executeDate>0){
			flag=true;
		}
		DBconn.sqlClose();
		return flag;
	}

	@Override
	public List<User> GetUserAll() {
		// TODO 自动生成的方法存根
		List<User> list=new ArrayList<User>();
		try{
			DBconn.init();
			ResultSet rs=DBconn.sqlSelect("select * from user");
			while(rs.next()){
				User user=new User();
				user.SetId(rs.getInt("Id"));
				user.SetName(rs.getString("name"));
				user.SetPwd(rs.getString("pwd"));
				user.SetSex(rs.getString("sex"));
				user.SetHome(rs.getString("home"));
				user.SetInfo(rs.getString("info"));
				list.add(user);		
			}
			DBconn.sqlClose();
			return list;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO 自动生成的方法存根
		int executeUpdate=0;
		boolean flag=false;
		DBconn.init();
		try {
			String sql="delete * from user where id=?";
			PreparedStatement ps=DBconn.getPreparedStatement(sql);
			ps.setInt(1, id);
			executeUpdate=ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(executeUpdate>0){
			flag=true;
		}
		DBconn.sqlClose();
		return flag;
	}

	@Override
	public boolean upDate(int Id,String name,String pwd,String sex,String home,String info) {
		// TODO 自动生成的方法存根
		boolean flag=false;
		DBconn.init();
		String sql="update user set name='"+name
				+"',pwd='"+pwd
				+"',sex='"+sex
				+"',home='"+home
				+"',info='"+info
				+"'where id="+Id;
		int i=DBconn.addDeleteUpdate(sql);
		if(i>0){
			flag=true;
		}
		DBconn.sqlClose();
		return flag;
	}

}









