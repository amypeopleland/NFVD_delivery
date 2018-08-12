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

public class AddGoodsName extends HttpServlet {


	public AddGoodsName() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductName_service t=new ProductName_service();
		HttpSession session =request.getSession();
		int flag=Integer.parseInt(session.getAttribute("flag").toString());
		Products p=new Products();
		
		if(flag==1){
			int goods_number=Integer.parseInt(request.getParameter("GOODS_number"));
			String goods_name=request.getParameter("GOODS_name");
			p.setGoodsName(goods_name);
			p.setGoodsNumber(goods_number);
		}
		
		
		if(flag==3){
			String good_Area=request.getParameter("GOODS_AreaName");
			int goodArea_Num=Integer.parseInt(request.getParameter("GOODS_AreaNum"));
			
			p.setGoodArea(good_Area);
			p.setGoodAreaNum(goodArea_Num);
		}
		
		if(flag==2){
			int goods_number=Integer.parseInt(request.getParameter("GOODS_number"));
			int goodArea_Num=Integer.parseInt(request.getParameter("GOODS_Areanum"));
			
			p.setGoodsNumber(goods_number);
			p.setGoodAreaNum(goodArea_Num);
		}
		
		t.addProducts(p,flag);
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
