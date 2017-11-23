package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
	public  boolean login(String name,String pwd );
	public boolean regist(User user);
	public List<User> GetUserAll();
	public boolean delete(int Id);
	public boolean upDate(int Id,String name,String pwd,String sex,String home,String info);
}
