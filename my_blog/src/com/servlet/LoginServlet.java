package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoimpl;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5285600116871825644L;
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException,IOException{
		doPost(request,response);
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws  ServletException,IOException{
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		
		UserDao ud=new UserDaoimpl();
		if(ud.login(name,pwd)){
			request.setAttribute("xiaoxi", "”√ªß"+name);
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}
		else
		{
			response.sendRedirect("index.jsp");
		}
	}
}
