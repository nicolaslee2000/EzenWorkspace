package jdbc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DAO {
	//TODO type check, preparedstatement
	private static DAO dao = null;
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ResultSetMetaData rsmd;

	private static Class<?> cls;
	
	private DAO() {};
	
	public static DAO getInstance(Class<?> c) {
		if(dao == null) {
			dao = new DAO();
		}
		cls = c;
		return dao;
	}

	
	private void initConnect() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String username = "hr";
		String password = "a1234";
		conn = DriverManager.getConnection(url, username, password);
	}
	
	private void initQuery(String query) throws SQLException {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		rsmd = rs.getMetaData();
	}
	
	private void getColumns() {
		List<String> fields = Arrays.stream(cls.getDeclaredFields()).map(e -> e.getName()).collect(Collectors.toList());
		fields.forEach(System.out::println);
	}
	private void exit() throws SQLException {
		if(conn != null) {
			conn.close();
		}
		if(stmt != null) {
			stmt.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(rs != null) {
			rs.close();
		}

	}
	
	public List<Object> getContent(String query) {
		List<Object> content = new ArrayList<>();
		String[] columns = null;
		try {
			initConnect();
			initQuery(query);
			int columnCnt = rsmd.getColumnCount();
			columns = new String[columnCnt];
			for(int i = 0; i < columnCnt; i ++) {
				columns[i] = rsmd.getColumnName(i+1).toLowerCase();
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		Field[] fields = cls.getDeclaredFields();
		List<String> cn = new ArrayList<>();
		for(int i = 0; i < fields.length; i++) {
			if(Arrays.stream(columns).anyMatch(fields[i].getName()::equals)) {
				cn.add(fields[i].getName());
			}
		}
		try {
			while(rs.next()) {
				Object obj = cls.getDeclaredConstructor().newInstance();
				Map<Class<?>, Method> map = initResultSetMethods();
				for(String str : cn) {
					Field field = cls.getDeclaredField(str);
					field.setAccessible(true);
					//set field of obj, invoke method of rs which is implementing methods of ResultSet
					//rs is an instance of Method that reflects the method being invoked
					field.set(obj, map.get(field.getType()).invoke(rs, str));
					System.out.println(obj);
				}
				content.add(obj);
			}
		} catch (SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | NoSuchFieldException e) {
			e.printStackTrace();
		}
		try {
			exit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getColumns();
		return content;
	}
	
	
	
	
	private Map<Class<?>, Method> initResultSetMethods() {
		//creating anonymous abstract class implementing ResultSet to get methods of ResultSet
		abstract class ResultSetClass implements ResultSet {}
		Class<?> resultSet = ResultSetClass.class;
		Method[] rsMethods = resultSet.getMethods();
		
		return Arrays.stream(rsMethods)
			.filter(e -> e.getParameterCount() == 1)
			.filter(e -> e.getParameterTypes()[0].equals(String.class))
			.filter(e -> e.getName().substring(3).compareToIgnoreCase(e.getReturnType().getSimpleName()) == 0)
			.collect(Collectors.toMap(e -> e.getReturnType(), e -> e));
	}

}
