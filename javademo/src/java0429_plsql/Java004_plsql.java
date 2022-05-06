package java0429_plsql;
/*
CREATE OR REPLACE PROCEDURE my_select
(v_empid in number,
 v_name out varchar2 ,
 v_salary out number)
 
IS
BEGIN
SELECT first_name,salary
INTO v_name,v_salary
FROM employees
WHERE employee_id=v_empid;
END;
/
*/
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import template.JdbcTemplate;

public class Java004_plsql {
 
		private Connection conn;
		private CallableStatement cstmt;
		private ResultSet rs;
public Java004_plsql() {			
 }
public void process() {
	try {
		conn= JdbcTemplate.getConnection();
		String sql="{call my_select(?,?,?)}";
		cstmt=conn.prepareCall(sql);

		//입력IN
		cstmt.setInt(1, 100);
		
		//반환값
		//단순히 오라클에서 값을 받을때 타입스하고 타입을 명시
		cstmt.registerOutParameter(2, Types.VARCHAR);
		cstmt.registerOutParameter(3, Types.DOUBLE);
		cstmt.execute();
		
		System.out.printf("%s %.2f\n", cstmt.getString(2),cstmt.getDouble(3));
	
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}finally {
		JdbcTemplate.close(conn);
		JdbcTemplate.close(rs);
		JdbcTemplate.close(cstmt);
	}
	
 }//end process	

	
public static void main(String[] args) {
	new Java004_plsql().process();
	}//end main
}//end class
