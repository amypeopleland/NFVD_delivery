package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	public String SelectLoginByname(String name){
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		String code=null;
		ResultSet rs = null;
		try {
			String sql ="select usercode from LoginMembership where username=?";
		
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			
			if(rs!=null){
				while (rs.next()) {
					code=rs.getString("usercode");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}

}
