package java0425_jdbc.part01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public JdbcTest() {
		
	}
	public void process() {
		try {
			//1. load driver
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. connect server
			String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
			String username = "hr";
			String password = "a1234";
			conn = DriverManager.getConnection(url, username, password);
			
			//3. get instance of statement
			stmt = conn.createStatement();
			
			//4. run statement select - executeQUery(), insert/update/delete - executeUpdate()
			String query = "SELECT * FROM departments ORDER BY department_id";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt("department_id");
				System.out.println(id);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
