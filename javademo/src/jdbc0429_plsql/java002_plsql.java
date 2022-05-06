package jdbc0429_plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcTemplate;
import oracle.jdbc.internal.OracleTypes;

public class java002_plsql {
	private Connection conn;
	private CallableStatement cstmt;
	private ResultSet rs;
	public java002_plsql() {
		process();
	}

	public void process() {
		try {
			conn = JdbcTemplate.getConnection();
			String query = "{call pl_emplist(?,?)}";
			cstmt = conn.prepareCall(query);
			cstmt.setInt(1, 20);
			
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();
			rs = (ResultSet) cstmt.getObject(2);
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
				System.out.println(rs.getInt(4));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(cstmt);
			JdbcTemplate.close(conn);
		}
		
		
	}
	
	public static void main(String[] args) {
		new java002_plsql();
	}

}
