package Buyer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.Buy;
import com.service.Admini_service;
import com.service.Buy_service;

public class Buyadd extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Buyadd() {
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

		Buy_service t=new Buy_service();
		int sum=0,remain=0;
		int goodsNumber=Integer.parseInt(request.getParameter("goods_number"));
		int goodsSellSum=Integer.parseInt(request.getParameter("amount"));
		String status_="NO";
		
		Buy b=new Buy();
		b.setGoodsNumber(goodsNumber);
		b.setGoodsSellSum(goodsSellSum);
		b.setStatus_(status_);
		t.add(b);
		
		Admini_service a=new Admini_service();
		sum=a.getGOODS_remain(goodsNumber);
		remain=sum-goodsSellSum;
		
		a.Updateremain(remain, goodsNumber);
		
		request.setAttribute("remain", remain);
		request.getRequestDispatcher("/servlet/BuyerListBuyPage").forward(request, response);

	
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
