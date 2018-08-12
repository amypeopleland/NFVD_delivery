package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao {
	public void addGoods(Goods t) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "insert into dbo.Stock(GOODS_ID,GOODS_number,GOODS_bid,GOODS_sell,GOODS_sum,GOODS_remain) values(?,?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, t.getGoodsId());
			pst.setInt(2, t.getGoodsNumber());
			pst.setFloat(3, t.getGoodsBid());
			pst.setFloat(4, t.getGoodsSell());
			pst.setFloat(5, t.getGoodsSum());
			pst.setFloat(6, t.getGoodsRemain());

			pst.executeUpdate();
			// rs=pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, pst, rs);
		}
	}

	public List<Goods> findAllGoods() {
		List<Goods> list = new ArrayList<Goods>();
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from Stock,Products where stock.GOODS_number=Products.GOODS_number";
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Goods t = new Goods();
					t.setGoodsId(rs.getInt("GOODS_ID"));
					t.setGoodsName(rs.getString("GOODS_name"));
					t.setGoodsNumber(rs.getInt("GOODS_number"));
					t.setGoodsBid(rs.getFloat("GOODS_bid"));
					t.setGoodsSell(rs.getFloat("GOODS_sell"));
					t.setGoodsSum(rs.getFloat("GOODS_sum"));
					t.setGoodsRemain(rs.getFloat("GOODS_remain"));
					list.add(t);
				}
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, pst, rs);
		}

		return list;

	}

	public Goods findGoodsById(String id) {
		Goods t = new Goods();
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select * from dbo.Stock where GOODS_ID=?";

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);// 1指的是第一个问号的占位符。后面的id指的是查询哪个产品
			rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					t.setGoodsId(rs.getInt("GOODS_ID"));
					t.setGoodsNumber(rs.getInt("GOODS_number"));
					t.setGoodsBid(rs.getFloat("GOODS_bid"));
					t.setGoodsSell(rs.getFloat("GOODS_sell"));
					t.setGoodsSum(rs.getFloat("GOODS_sum"));
					t.setGoodsRemain(rs.getFloat("GOODS_remain"));

				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, pst, rs);
		}
		return t;

	}

	public Goods UpdateGoodsByID(Goods tt) {

		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "update dbo.Stock set Goods_number=?,Goods_bid=?,Goods_sell=?,Goods_sum=?,Goods_remain=? where GOODS_ID=?";

		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, tt.getGoodsNumber());// 1指的是第一个问号的占位符。后面的id指的是查询哪个产品
			pst.setFloat(2, tt.getGoodsBid());
			pst.setFloat(3, tt.getGoodsSell());
			pst.setFloat(4, tt.getGoodsSum());
			pst.setFloat(5, tt.getGoodsRemain());
			pst.setInt(6, tt.getGoodsId());
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, pst, rs);
		}
		return tt;

	}

	public int DeleteGoods(int id) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "delete from Stock where Goods_id=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public List<Goods> findAllToBuyGoods() {
		List<Goods> list = new ArrayList<Goods>();
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select a.GOODS_ID,b.GOODS_name,c.GOODS_AreaName,a.GOODS_sell,a.GOODS_remain from Stock as a,Products as b,GoodArea as c,ProductsAreaID as d where a.GOODS_number=b.GOODS_number and b.GOODS_number=d.GOODS_number and d.GOODS_AreaNum=c.GOODS_AreaNum Order by a.GOODS_number";
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Goods t = new Goods();
					t.setGoodsId(rs.getInt("GOODS_ID"));
					t.setGoodsName(rs.getString("GOODS_name"));
					t.setGoodsSell(rs.getFloat("GOODS_sell"));
					t.setGoodsRemain(rs.getFloat("GOODS_remain"));
					t.setGoodsAreaName(rs.getString("GOODS_AreaName"));
					list.add(t);
				}
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, pst, rs);
		}

		return list;
	}
	public Goods BuyerById(int id){
		Goods t = new Goods();
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select a.GOODS_number,b.GOODS_name,c.GOODS_AreaName,a.GOODS_sell,a.GOODS_remain from Stock as a,Products as b,GoodArea as c,ProductsAreaID as d where a.GOODS_number=b.GOODS_number and b.GOODS_number=d.GOODS_number and d.GOODS_AreaNum=c.GOODS_AreaNum and a.GOODS_number=? Order by a.GOODS_number";

		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);// 1指的是第一个问号的占位符。后面的id指的是查询哪个产品
			rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					t.setGoodsNumber(rs.getInt("GOODS_number"));
					t.setGoodsName(rs.getString("GOODS_name"));
					t.setGoodsAreaName(rs.getString("GOODS_AreaName"));
					t.setGoodsSell(rs.getFloat("GOODS_sell"));
					t.setGoodsRemain(rs.getFloat("GOODS_remain"));

				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, pst, rs);
		}
		return t;
	}
	
	public int getGOODS_remain(int id){
		int remain=0;
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql = "select GOODS_remain from Stock where GOODS_number=?";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);// 1指的是第一个问号的占位符。后面的id指的是查询哪个产品
			rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					remain=rs.getInt("GOODS_remain");
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, pst, rs);
		}
		return remain;
	}
	public void Updateremain(int remain,int number){
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql = "update dbo.Stock set Goods_remain=? where GOODS_ID=?";

		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, remain);// 1指的是第一个问号的占位符。后面的id指的是查询哪个产品
			pst.setFloat(2, number);
			
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, pst, rs);
		}
	
	}
	

}
