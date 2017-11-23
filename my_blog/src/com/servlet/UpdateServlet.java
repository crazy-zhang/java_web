package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoimpl;

public class UpdateServlet {
	 public void doGet(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
	       doPost(request, response);  
   }  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
           throws ServletException, IOException {
    	String id =request.getParameter("id");
    	int userId=Integer.parseInt(id);
    	
    	String name=request.getParameter("name");
    	String pwd=request.getParameter("pwd");
    	String sex=request.getParameter("sex");
    	String home=request.getParameter("home");
    	String info=request.getParameter("info");
    	
    	UserDao ud =new UserDaoimpl();
    	if(ud.upDate(userId, name, pwd, sex, home, info)){
    		request.setAttribute("xaioxi", "ÐÞ¸Ä³É¹¦");
    		request.getRequestDispatcher("/searchall.jsp").forward(request, response);
    	}
    	else{
    		response.sendRedirect("index.jsp");
    	}
    	
    }


}
