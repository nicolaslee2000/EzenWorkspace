package java0429_plsql;
/*
1. Stored Procedure
Stored Procedure는 DB 내에 프로시저를 선언하여 클라이언트가 필요할 때마다 호출하여 사용하도록 하는 단위로 저장된 프로시저이다.
이는 클라이언트에서 SQL 문을 실행하는 것이 아니라 DB에 프로시저가 존재하는 것이므로 클라이언트에서 저장된 프로시저를 실행만 해주면 그 내용이 oracle 내에서 바로 처리된다. 따라서 속도가 빠르며 부하가 적고 DB 내 존재하는 특성이 있다.

2. CallableStatement
CallableStatement는 DB 내의 Stored Procedure을 호출하기 위한 객체로, 이 객체는 PreparedStatement 객체를 상속받아 사용한다.
이 객체에서 registeroutParameter() 메소드는 프로시저에서 넘어오는 값을 받환 받기 위해서는 필요하며, 프로시저로부터 넘어오는 값의 타입을 지정해주는 역할을 한다. 

3. 자바에서  PL-SQL select 
-조회결과를 볼 수 있는 제어권을 자바로 넘기기 위해서 사용하는 커서  (SYS_REFCUSOR)
-procedure에서는 커서를 open만 한다.
- fetch, close를 하지 않는다.

 프로시저 생성
 CREATE OR REPLACE PROCEDURE pl_emplist
  (v_deptno in number,
    --app에서 값을 사용하기 위해서(Multi row)
   v_cursor out sys_refcursor )
 IS
   
 BEGIN
   open v_cursor
   for 
    select employee_id,first_name,
           salary,department_id
    from employees
    where department_id=v_deptno;  
       
 END;
 /
 */

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.internal.OracleTypes;
import template.JdbcTemplate;

public class Java003_plsql {
	private Connection conn;
	private CallableStatement cstmt;
	private ResultSet rs;
	
	public Java003_plsql() {
		
	}
	
	public void process() {
		try {
			conn= JdbcTemplate.getConnection();
			String sql="{call pl_emplist(?,?)}";
			cstmt=conn.prepareCall(sql);
			//입력IN
			cstmt.setInt(1, 20);
			
			//출력 OUT 값을 가져오기 위한
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();
			rs= (ResultSet)cstmt.getObject(2);
			
			while(rs.next()) {
				System.out.printf("%d %s %d %s\n", 
								  rs.getInt("employee_id"),
								  rs.getString("first_name"),
								  rs.getInt("salary"),
								  rs.getString("department_id"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(cstmt);
			JdbcTemplate.close(conn);
		}
		
	}
	
	public static void main(String[] args) {
		new Java003_plsql().process();

	}//end mian

}//end class
