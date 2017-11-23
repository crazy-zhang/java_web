package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoimpl;
import com.entity.User;

public class SearchAll extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5785313057527946355L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
				UserDao ud=new UserDaoimpl();
				List<User> userAll=ud.GetUserAll();
				request.setAttribute("UserAll", userAll);
				request.getRequestDispatcher("/showall.jsp").forward(request, response);
				
			}

}
