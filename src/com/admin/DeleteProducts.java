package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ProductName_service;

public class DeleteProducts extends HttpServlet {

	public DeleteProducts() {
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

		ProductName_service t=new ProductName_service();
		int id;
		int flag=Integer.parseInt(request.getParameter("flag"));
		
		if(flag==3){
			id=Integer.parseInt(request.getParameter("GOODS_AreaNum"));
			
		}
		else{
			id=Integer.parseInt(request.getParameter("GOODS_number"));
		}
		t.deleteProducts(id,flag);
		request.getRequestDispatcher("/admini/admini.jsp").forward(request, response);
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
