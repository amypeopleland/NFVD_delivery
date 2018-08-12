package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.Goods;
import com.service.Admini_service;

public class AddGoods extends HttpServlet {

	
	public AddGoods() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//int goods_id=(int)request.getParameter("GOODS_ID");
		Admini_service ts=new Admini_service();
		int goods_id=Integer.parseInt(request.getParameter("GOODS_ID"));
		int goods_number=Integer.parseInt(request.getParameter("GOODS_number"));
		float goods_bid=Float.parseFloat(request.getParameter("GOODS_bid"));
		float goods_sell=Float.parseFloat(request.getParameter("GOODS_sell"));
		float goods_sum=Float.parseFloat(request.getParameter("GOODS_sum"));
		float goods_remain=Float.parseFloat(request.getParameter("GOODS_remain"));
		
		Goods t=new Goods();
		t.setGoodsId(goods_id);
		t.setGoodsNumber(goods_number);
		t.setGoodsBid(goods_bid);
		t.setGoodsSell(goods_sell);
		t.setGoodsSum(goods_sum);
		t.setGoodsRemain(goods_remain);
		
		ts.addGoods(t);
		
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
