package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoimpl;

public class DeleteServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
				doPost(request,response);
			}
			public void doPost(HttpServletRequest request,HttpServletResponse response)
					throws ServletException,IOException{
				String id=request.getParameter("id");
				int userId=Integer.parseInt(id);
				
				UserDao ud=new UserDaoimpl();
				if(ud.delete(userId)){
					request.setAttribute("xioaxi", "É¾³ý³É¹¦");
					request.getRequestDispatcher("/searchall.jsp").forward(request, response);
				}
				else{
					response.sendRedirect("index.jsp");
				}
			}

}
