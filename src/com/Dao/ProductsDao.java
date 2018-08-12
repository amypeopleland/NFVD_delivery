package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsDao {
	public List<Products> findAllProductsName(int flag) {

		List<Products> p = new ArrayList<Products>();

		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		if (flag == 1 || flag==4) {
			String sql = "select * from dbo.Products";
			try {
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						Products t = new Products();
						t.setGoodsName(rs.getString("GOODS_name"));
						t.setGoodsNumber(rs.getInt("GOODS_number"));
						p.add(t);
					}
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.close(con, pst, rs);
			}
		} else if (flag == 2) {
			String sql = "select a.GOODS_number,a.GOODS_name,b.GOODS_AreaNum,c.GOODS_AreaName from dbo.Products as a,dbo.ProductsAreaID as b,dbo.GoodArea as c Where a.GOODS_number=b.GOODS_number and b.GOODS_AreaNum=c.GOODS_AreaNum";
			try {
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						Products t = new Products();
						t.setGoodsName(rs.getString("GOODS_name"));
						t.setGoodsNumber(rs.getInt("GOODS_number"));
						t.setGoodAreaNum(rs.getInt("GOODS_AreaNum"));
						t.setGoodArea(rs.getString("GOODS_AreaName"));
						p.add(t);
					}
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.close(con, pst, rs);
			}
		} else if (flag == 3) {
			String sql = "select * from dbo.GoodArea";
			try {
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						Products t = new Products();
						t.setGoodArea(rs.getString("GOODS_AreaName"));
						t.setGoodAreaNum(rs.getInt("GOODS_AreaNum"));
						p.add(t);
					}
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.close(con, pst, rs);
			}
		}

		return p;
	}

	public String findProductsName(int Goods_number) {
		String Goods_nameP = null;
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select GOODS_name from dbo.Products Where GOODS_number=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, Goods_number);
			rs = pst.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Goods_nameP = rs.getString("GOODS_name");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, pst, rs);
		}
		return Goods_nameP;

	}

	public void addProductsName(Products p, int flag) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		if (flag == 1) {
			String sql = "insert into dbo.Products(GOODS_number,GOODS_name) values(?,?)";
			try {
				pst = con.prepareStatement(sql);
				pst.setInt(1, p.getGoodsNumber());
				pst.setString(2, p.getGoodsName());

				pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.close(con, pst, rs);
			}
		} else if (flag == 2) {
			Connection con_area = JDBCUtil.getConnection();
			PreparedStatement pst_area = null;
			ResultSet rs_area = null;
			String sql_area = "insert into dbo.ProductsAreaID(GOODS_number,GOODS_AreaNum) values(?,?)";
			try {
				pst_area = con_area.prepareStatement(sql_area);
				pst_area.setInt(1, p.getGoodsNumber());
				pst_area.setInt(2, p.getGoodAreaNum());

				pst_area.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.close(con_area, pst_area, rs_area);
			}
		} else if (flag == 3) {
			Connection con_area = JDBCUtil.getConnection();
			PreparedStatement pst_area = null;
			ResultSet rs_area = null;
			String sql_area = "insert into dbo.GoodArea(GOODS_AreaNum,GOODS_AreaName) values(?,?)";
			try {
				pst_area = con_area.prepareStatement(sql_area);
				pst_area.setInt(1, p.getGoodAreaNum());
				pst_area.setString(2, p.getGoodArea());

				pst_area.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.close(con_area, pst_area, rs_area);
			}
		}

	}

	public void deleteProducts(int id, int flag) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		if (flag == 1) {
			String sql = "delete from dbo.Products where GOODS_number=?";

			try {
				pst = con.prepareStatement(sql);
				pst.setInt(1, id);
				pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.close(con, pst, rs);
			}
		} else if (flag == 2) {

			String sql_2 = "delete from ProductsAreaID where GOODS_number=?";

			try {
				pst = con.prepareStatement(sql_2);
				pst.setInt(1, id);
				pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.close(con, pst, rs);
			}

		} else if (flag == 3) {
			String sql_2 = "delete from GoodArea where GOODS_AreaNum=?";

			try {
				pst = con.prepareStatement(sql_2);
				pst.setInt(1, id);
				pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.close(con, pst, rs);
			}
		}

	}

	public Products findProductsNameId(int Goods_number){
		Products p = new Products();
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from dbo.Products where GOODS_number=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, Goods_number);
			rs = pst.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					p.setGoodsName(rs.getString("GOODS_name"));
					p.setGoodsNumber(rs.getInt("Goods_number"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, pst, rs);
		}

		return p;
	}
	
	public Products findProductsNameById(int Goods_number) {
		Products p = new Products();
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select a.GOODS_number,a.GOODS_name,b.GOODS_AreaNum,c.GOODS_AreaName from dbo.Products as a,dbo.ProductsAreaID as b,dbo.GoodArea as c Where a.GOODS_number=b.GOODS_number and b.GOODS_AreaNum=c.GOODS_AreaNum and a.GOODS_number=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, Goods_number);
			rs = pst.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					p.setGoodsName(rs.getString("GOODS_name"));
					p.setGoodsNumber(rs.getInt("Goods_number"));
					p.setGoodAreaNum(rs.getInt("GOODS_AreaNum"));
					p.setGoodArea(rs.getString("GOODS_AreaName"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, pst, rs);
		}

		return p;
	}

	public Products findProductsAreaById(int GOODS_AreaNum) {
		Products p = new Products();
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from dbo.GoodArea where GOODS_AreaNum=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, GOODS_AreaNum);
			rs = pst.executeQuery();

			if (rs != null) {
				while (rs.next()) {

					p.setGoodAreaNum(rs.getInt("GOODS_AreaNum"));
					p.setGoodArea(rs.getString("GOODS_AreaName"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, pst, rs);
		}

		return p;
	}

	public void UpdateProducts(Products p, int flag) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;

		if (flag == 1) {
			String sql = "update dbo.Products set Goods_name=? where Goods_number=?";
			try {
				pst = con.prepareStatement(sql);

				pst.setString(1, p.getGoodsName());
				pst.setInt(2, p.getGoodsNumber());// 1指的是第一个问号的占位符。后面的id指的是查询哪个产品
				pst.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.close(con, pst, rs);
			}

		}

		if (flag == 2) {
			con = JDBCUtil.getConnection();
			pst = null;
			rs = null;

			String sql_2 = "update dbo.ProductsAreaID set GOODS_AreaNum=? where Goods_number=?";
			try {
				pst = con.prepareStatement(sql_2);

				pst.setInt(1, p.getGoodAreaNum());
				pst.setInt(2, p.getGoodsNumber());// 1指的是第一个问号的占位符。后面的id指的是查询哪个产品
				pst.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.close(con, pst, rs);
			}
		}

		if (flag == 3) {
			con = JDBCUtil.getConnection();
			pst = null;
			rs = null;

			String sql_2 = "update dbo.GoodArea set GOODS_AreaName =? where GOODS_AreaNum=?";
			try {
				pst = con.prepareStatement(sql_2);

				pst.setString(1, p.getGoodArea());
				pst.setInt(2, p.getGoodAreaNum());// 1指的是第一个问号的占位符。后面的id指的是查询哪个产品
				pst.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.close(con, pst, rs);
			}
		}

	}

}
