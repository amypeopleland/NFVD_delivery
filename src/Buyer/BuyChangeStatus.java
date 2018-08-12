package Buyer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Buy_service;

public class BuyChangeStatus extends HttpServlet {

	
	public BuyChangeStatus() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Buy_service p=new Buy_service();
		int sell_Number=Integer.parseInt(request.getParameter("sell_Number"));
		int sta=Integer.parseInt(request.getParameter("sta"));
		
		p.ChangeStatus(sta, sell_Number);
		request.getRequestDispatcher("/servlet/Sender").forward(request, response);
		
	
		
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		doGet(request, response);
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
