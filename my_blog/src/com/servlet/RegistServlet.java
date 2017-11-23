package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoimpl;
import com.entity.User;

public class RegistServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5237762551272360904L;
	public void doGet(HttpServletRequest request,HttpServletResponse response )
	throws ServletException ,IOException{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response )
			throws ServletException ,IOException{
				String name=request.getParameter("name");
				String pwd=request.getParameter("pwd");
				String sex=request.getParameter("sex");
				String home=request.getParameter("home");
				String info=request.getParameter("info");
				
				User user=new User();
				user.SetName(name);
				user.SetPwd(pwd);
				user.SetSex(sex);
				user.SetHome(home);
				user.SetInfo(info);
				
				UserDao ud=new UserDaoimpl();
				if(ud.regist(user)){
					request.setAttribute("username", name);
					request.getRequestDispatcher("/WEB-INF/lib/regist.jsp").forward(request, response);
				}else{
					response.sendRedirect("index.jsp");
				}
				
			}
}










