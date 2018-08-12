package Buyer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.Buy;
import com.service.Buy_service;

public class Sender extends HttpServlet {

	
	public Sender() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Buy_service b=new Buy_service();
		List<Buy> d=b.findBuyListByNumber();
		//int flag=Integer.parseInt((String) request.getAttribute("flag"));
		
		request.setAttribute("d", d);
//		if(flag==1){
//			request.getRequestDispatcher("/send/ShowToCUS.jsp").forward(request, response);
//		}
//		else{
//			request.getRequestDispatcher("/send/SendPage.jsp").forward(request, response);
//		}
		request.getRequestDispatcher("/send/SendPage.jsp").forward(request, response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
