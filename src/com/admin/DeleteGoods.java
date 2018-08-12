package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Admini_service;

public class DeleteGoods extends HttpServlet {

	
	public DeleteGoods() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Admini_service ts=new Admini_service();
		int flag=0;
		//int id=Integer.valueOf(request.getParameter("GOODS_number"));°ü×°³ÉInteger
		int id=Integer.parseInt(request.getParameter("GOODS_ID"));
		flag=ts.DeleteGoods(id);
		
		request.getRequestDispatcher("/admini/admini.jsp").forward(request, response);
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
