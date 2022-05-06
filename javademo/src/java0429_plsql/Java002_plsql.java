package java0429_plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import template.JdbcTemplate;

public class Java002_plsql {
	private Connection conn;
	private CallableStatement cstmt;
	
	public Java002_plsql() {
		
	}

	public void process() {
		try {
			conn=JdbcTemplate.getConnection();
			//String sql = "begin pro_othermode(?,?);end;";
			String sql="{call pro_othermode(?,?)}";
			cstmt= conn.prepareCall(sql);
			cstmt.setString(1, "나타샤");
			cstmt.setString(2, "부산");
			cstmt.executeUpdate();
			System.out.println("insert end");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(cstmt);
			JdbcTemplate.close(conn);
		}
		
	}//end process
	
	public static void main(String[] args) {
		new Java002_plsql().process();

	}//end main

}//end class
