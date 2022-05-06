package java0429_plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import template.JdbcTemplate;

public class Java001_plsql {
	private Connection conn;
	private CallableStatement cstmt;
	
 public  Java001_plsql() {
	 
 }
 public  void process() {
	 try {
		conn= JdbcTemplate.getConnection();
		
	//	String sql="BEGIN projdbc01(?); END;";		
		String sql = "{call projdbc01(?)}";
		cstmt=conn.prepareCall(sql);
		cstmt.setString(1, "고수");
		cstmt.executeUpdate();
		System.out.println("insert end");
		
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}finally {
		JdbcTemplate.close(cstmt);
		JdbcTemplate.close(conn);
	}
	 
 }//emd process
		
 public static void main(String[]args) {
	new Java001_plsql().process();
} 
	
}//end class
