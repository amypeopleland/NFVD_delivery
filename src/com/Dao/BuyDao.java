package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BuyDao {
	public void add(Buy t) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "insert into dbo.SellHistory(No_sell,GOODS_number,SOLD_sum,Status_) values(?,?,?,?)";

		try {
			pst = con.prepareStatement(sql);
			int x=(int)(Math.random()*9000+1000);
			x=x*(int)(Math.random()*9000+1000);
			
			pst.setInt(1, x);
			pst.setInt(2, t.getGoodsNumber());

			pst.setInt(3, t.getGoodsSellSum());
			pst.setString(4, t.getStatus_());

			pst.executeUpdate();
			// rs=pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, pst, rs);
		}

	}

	public List<Buy> findBuyListByNumber() {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select e.No_sell,a.GOODS_number,b.GOODS_name,c.GOODS_AreaName,e.SOLD_sum,e.Status_ from Stock as a,Products as b,GoodArea as c,ProductsAreaID as d ,SellHistory as e where a.GOODS_number=b.GOODS_number and b.GOODS_number=d.GOODS_number and d.GOODS_AreaNum=c.GOODS_AreaNum and a.GOODS_number=e.GOODS_number Order by a.GOODS_number";
		List<Buy> d = new ArrayList<Buy>();
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			if (rs != null) {
				while (rs.next()) {

					pst = con.prepareStatement(sql);
					Buy t = new Buy();
					t.setSellNumber(rs.getInt("No_sell"));
					t.setGoodsNumber(rs.getInt("GOODS_number"));
					t.setGoodsName(rs.getString("GOODS_name"));
					t.setGoodsAreaName(rs.getString("GOODS_AreaName"));
					t.setGoodsSellSum(rs.getInt("SOLD_sum"));
					t.setStatus_(rs.getString("Status_"));
					d.add(t);
				}
			}
			// rs=pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, pst, rs);
		}
		return d;
	}

	
	
	public void ChangeStatus(int sta,int sell_Number){
		
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql = "update dbo.SellHistory set Status_=? where No_sell=?";
		
		try {
			pst = con.prepareStatement(sql);
			if(sta==0){
				String p="On The way";
				pst.setString(1, p);// 1指的是第一个问号的占位符。后面的id指的是查询哪个产品
				pst.setInt(2, sell_Number);
			}
			else{
				String p="Finished!";
				pst.setString(1, p);// 1指的是第一个问号的占位符。后面的id指的是查询哪个产品
				pst.setInt(2, sell_Number);
			}
			
			
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, pst, rs);
		}
	}

}
