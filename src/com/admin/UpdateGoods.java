package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.Goods;
import com.service.Admini_service;

public class UpdateGoods extends HttpServlet {

	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Admini_service ts=new Admini_service();
		 String id=request.getParameter("GOODS_ID");
		 Goods t=ts.findAllGoodsById(id);
		 
		 request.setAttribute("Goods", t);
		 request.getRequestDispatcher("/admini/UpdateGoods.jsp").forward(request, response);
		// request.getRequestDispatcher("/admini/GoodsList.jsp").forward(request, response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
