package jdbc0429_plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcTemplate;

public class java001_plsql {
	private Connection conn;
	private CallableStatement cstmt;
	
	public java001_plsql() {
		super();
		process();
	}

	public void process() {
		try {
			conn = JdbcTemplate.getConnection();
//			String query = "BEGIN projdbc01(?); END;";
			String query = "{call projdbc01(?)}";
			cstmt = conn.prepareCall(query);
			cstmt.setString(1, "yolo");
			cstmt.executeUpdate();
			conn.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(conn);
			JdbcTemplate.close(cstmt);
		}
		
		
	}
	
	public static void main(String[] args) {
		new java001_plsql();
	}
}

