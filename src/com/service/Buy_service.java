package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.Dao.Buy;
import com.Dao.BuyDao;
import com.Dao.JDBCUtil;

public class Buy_service {
	BuyDao p=new BuyDao();
	public void add(Buy t){
		p.add(t);
		
	}
	public List<Buy>  findBuyListByNumber(){
		return p.findBuyListByNumber();
	}
	public void ChangeStatus(int sta,int sell_Number){

		p.ChangeStatus(sta, sell_Number);
	}

	
}
