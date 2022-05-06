package jdbc0429_plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import jdbc.JdbcTemplate;

public class java003_plsql {
	private Connection conn;
	private CallableStatement cstmt;
	private ResultSet rs;
	public java003_plsql() {
		process();
	}
	public void process() {
		try {
			conn = JdbcTemplate.getConnection();
			String query = "{call my_select(?,?,?)}";
			cstmt = conn.prepareCall(query);
			cstmt.setInt(1, 100);
			
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.execute();
			
			System.out.println(cstmt.getString(2));
			System.out.println(cstmt.getDouble(3));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(cstmt);
			JdbcTemplate.close(conn);
		}
	}
	public static void main(String[] args) {
		new java003_plsql();
	}

}
