package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.Products;
import com.service.ProductName_service;

public class SetProducts extends HttpServlet {

	
	public SetProducts() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int flag=Integer.parseInt(request.getParameter("flag"));
		ProductName_service t=new ProductName_service();
		int id;
		
		Products p=new Products();
		if(flag==3){
			id=Integer.parseInt(request.getParameter("GOODS_AreaNum"));
			p=t.findProductsAreaById(id);
		}
		else if(flag==4) {
			id=Integer.parseInt(request.getParameter("GOODS_number"));
			p=t.findProductsId(id);
			flag=1;
		}
		else{
			id=Integer.parseInt(request.getParameter("GOODS_number"));
			p=t.findProductsById(id);
			
		}
		
		
	
		request.setAttribute("p", p);
		if(flag==1){
			
			request.getRequestDispatcher("/ProductsName/UpdateProducts.jsp").forward(request, response);
		}
		else if(flag==2){
			request.getRequestDispatcher("/ProductVSArea/UpdateProductVSArea.jsp").forward(request, response);
		}
		else if(flag==3){
			request.getRequestDispatcher("/ProductArea/UpdateAreaNameList.jsp").forward(request, response);
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
