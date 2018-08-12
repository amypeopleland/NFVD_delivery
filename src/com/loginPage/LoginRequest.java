package com.loginPage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.LoginService;

public class LoginRequest extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginRequest() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		response.setContentType("text/html;charset=utf-8");//输出过程中
		String admini_name=request.getParameter("name");//提交的地址(取回参数的方法)
		//admini_name =new String(admini_name.getBytes("ISO8859-1"),"UTF-8");//中文
//		System.out.println(admini_name);
//		
		String pwd=request.getParameter("pwd");
//
//		if(admini_name.equals("sa") && pwd.equals("888018")){
//			//request.getRequestDispatcher("/servlet/LoginAdmini").forward(request, response);
//			
//			
//			HttpSession session =request.getSession();
//			session.setAttribute("admini_name",admini_name);
//			request.getRequestDispatcher("/admini/admini.jsp").forward(request, response);
//			//response.sendRedirect(arg0);
//		}
//		else if(admini_name.equals("cus") && pwd.equals("cus")){
//			HttpSession session =request.getSession();
//			session.setAttribute("admini_name",admini_name);
//			request.getRequestDispatcher("/admini/admini.jsp").forward(request, response);
//		}
//		else if(admini_name.equals("dlv") && pwd.equals("dlv")){
//			HttpSession session =request.getSession();
//			session.setAttribute("admini_name",admini_name);
//			request.getRequestDispatcher("/admini/admini.jsp").forward(request, response);
//		}

		//response.getWriter().write(name+"<br>"+password+"<br>");
		
		
		LoginService t=new LoginService();
		String code=null;
		code=t.SelectLoginByname(admini_name);
		
		if(pwd.equals(code.trim())==true && admini_name.equals("sa")){
			
				HttpSession session =request.getSession();
				session.setAttribute("admini_name",admini_name);
				request.getRequestDispatcher("/admini/admini.jsp").forward(request, response);
		}
		else if(pwd.equals(code.trim())==true && admini_name.equals("send")){
			int flag=0;
			request.getRequestDispatcher("/servlet/Sender").forward(request, response);
		}
			else if(pwd.equals(code.trim())==true){
			request.getRequestDispatcher("/servlet/BuyerListBuyPage").forward(request, response);
			}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);//前台表单的提交

	}


	public void init() throws ServletException {
		// Put your code here
	}

}
