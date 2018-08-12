package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.ProductName_service;

public class SelectGoodsName extends HttpServlet {

	
	public SelectGoodsName() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductName_service ts=new ProductName_service();
		//int number=Integer.parseInt(request.getParameter("Goods_number"));
		HttpSession session =request.getSession();
		int number=Integer.parseInt((String)session.getAttribute("goods_number"));
		//int number=Integer.parseInt(request.getParameter("goods_number"));
		String name=ts.findProductsName(number);
		request.setAttribute("name", name);
		request.getRequestDispatcher("/admini/GoodsList.jsp").forward(request, response);
		
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
