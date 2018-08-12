package Buyer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.Goods;
import com.service.Admini_service;

public class BuyerListComfirmPage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BuyerListComfirmPage() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Admini_service ts=new Admini_service();
		Goods g=new Goods();
		
		int id=Integer.parseInt(request.getParameter("goods_number"));
		
		g=ts.BuyerById(id);
		request.setAttribute("g", g);
		request.getRequestDispatcher("/Buyer/BuyerListComfirmPage.jsp").forward(request, response);
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
