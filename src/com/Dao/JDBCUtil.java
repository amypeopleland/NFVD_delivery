package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	private static String dnUrl="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=NFVD";
	private static String dnUser="sa";
	private static String dbPwd="888018";
	private static String dbDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName(dbDriver);
			
		
		
			con=DriverManager.getConnection(dnUrl, dnUser, dbPwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void close(Connection con,PreparedStatement pst,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pst!=null){
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
