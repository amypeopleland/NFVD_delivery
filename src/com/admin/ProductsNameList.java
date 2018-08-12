package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.Products;
import com.service.ProductName_service;

public class ProductsNameList extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ProductsNameList() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductName_service ts=new ProductName_service();
		int flag=Integer.parseInt(request.getParameter("flag"));
//		if(flag==1){
			List<Products> list=ts.findAllProducts(flag);
			request.setAttribute("list",list);
			request.setAttribute("flag",flag);
//		}
//		else
//		{
//			
//		}
		
		
		if(flag==1){
			
			request.getRequestDispatcher("/ProductsName/ProductsNameList.jsp").forward(request, response);
		}
		else if(flag==2){
			request.getRequestDispatcher("/ProductVSArea/ProductVSAreaList.jsp").forward(request, response);
			
		}
		else if(flag==3){
			request.getRequestDispatcher("/ProductArea/ProductsAreaNameList.jsp").forward(request, response);
		}
		else if(flag==4){
			request.getRequestDispatcher("/admini/AddGoods.jsp").forward(request, response);
		}
		

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
