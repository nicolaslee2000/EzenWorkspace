package jdbc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
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
import java.util.function.Consumer;
import java.util.stream.Collectors;

import java0425_jdbc.part04.DepartmentsDTO;
import java0425_jdbc.part04.EmployeesDTO;
import java0425_jdbc.part04.LocationDTO;

public class JdbcOrm {
	//TODO type check, preparedstatement, rollback, sequence
	//error check(primary key) consumer improvement insert two options
	private static JdbcOrm dao = null;
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ResultSetMetaData rsmd;

	private static Class<?> cls;
	
	private JdbcOrm() {};
	
	public static JdbcOrm getInstance(Class<?> c) {
		if(dao == null) {
			dao = new JdbcOrm();
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
		conn.setAutoCommit(false);
	}
	
	private void initStmt(String query) throws SQLException {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
	}
	
	private void initPstmt(String query, Consumer<PreparedStatement> con) throws SQLException {
		pstmt = conn.prepareStatement(query);
		con.accept(pstmt);
		rs = pstmt.executeQuery();
	}
	
	private List<String> getColumns() throws SQLException {
		//matching object fields to column names is case insensitive
		rsmd = rs.getMetaData();
		List<String> fields = Arrays.stream(cls.getDeclaredFields()).map(e -> e.getName().toLowerCase()).collect(Collectors.toList());
		List<String> columns = new ArrayList<>();
		for(int i = 0; i < rsmd.getColumnCount(); i++) {
			columns.add(rsmd.getColumnName(i+1).toLowerCase());
		}
		fields.retainAll(columns);
		return fields;
	}
	
	private List<String> getColumns(Class<?> joiningClass) throws SQLException {
		//matching object fields to column names is case insensitive
		rsmd = rs.getMetaData();
		List<String> fields = Arrays.stream(cls.getDeclaredFields()).map(e -> e.getName().toLowerCase()).collect(Collectors.toList());
		List<String> columns = new ArrayList<>();
		for(int i = 0; i < rsmd.getColumnCount(); i++) {
			columns.add(rsmd.getColumnName(i+1).toLowerCase());
		}
		fields.retainAll(columns);
		return fields;
	}
	
	
	@SuppressWarnings("unchecked")
	private <T> List<T> getContentList() throws Exception {
		List<T> content = new ArrayList<>();
		while(rs.next()) {
			Object obj = cls.getDeclaredConstructor().newInstance();
			Map<Class<?>, Method> methods = getRSMethods();
			for(String str : getColumns()) {
				Field field = cls.getDeclaredField(str);
				field.setAccessible(true);
				//set field of obj, invoke method of rs which is implementing methods of ResultSet
				//rs is an instance of Method that reflects the method being invoked
				field.set(obj, methods.get(field.getType()).invoke(rs, str));
			}
			content.add((T) obj);
		}
		return content;
	}
	
	@SuppressWarnings("unchecked")
	private <T> List<T> getJoinedContentList(Class<?> joiningClass) throws Exception {
		List<T> content = new ArrayList<>();
		while(rs.next()) {
			Object obj = cls.getDeclaredConstructor().newInstance();
			//get joining key of two tables
			String s = Arrays.stream(obj.getClass().getDeclaredFields())
				.filter(e -> e.getName().compareToIgnoreCase(joiningClass.getSimpleName()) == 0)
				.map(e -> e.getName())
				.findFirst()
				.orElse(null);
			Field f = obj.getClass().getDeclaredField(s);
			f.setAccessible(true);
			f.set(obj, joiningClass.getDeclaredConstructor().newInstance());
			
			Map<Class<?>, Method> methods = getRSMethods();
			for(String str : getColumns(joiningClass)) {
				Field field = null;
				try {
					field = cls.getDeclaredField(str);
					field.setAccessible(true);
					field.set(obj, methods.get(field.getType()).invoke(rs, str));
				} catch(NoSuchFieldException e) {
					field = joiningClass.getDeclaredField(str);
					field.setAccessible(true);
					field.set(f.get(obj).getClass().getDeclaredField(str), methods.get(field.getType()).invoke(rs, str));
				}
				
				
				
			}
			
			content.add((T) obj);
		}
		return content;
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
	public int insert(String tableName, Object obj) {
		try {
			initConnect();
			initStmt("SELECT * FROM " + tableName);
			
			String query = "INSERT INTO " + tableName + "(num";
			List<String> fields = new ArrayList<>();
			Field field = null;
			for(String s : getColumns()) {
				
				
				field = obj.getClass().getDeclaredField(s);
				field.setAccessible(true);
				System.out.println(field.get(obj).toString());
				if(field.get(obj) != null) {
					query += ","+s;
					fields.add(s);
				}
			}
			query += ") VALUES(mem_num_seq.nextval";
			for(String str : fields) {
				query += "," + field.get(obj);
			}
			query += ")";
			System.out.println(query);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}
	
	public <T> List<T> getContent(String query) {
		List<T> content = null;
		try {
			initConnect();
			initStmt(query);
			content = getContentList();
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return content;
	}
	
	public <T> List<T> getContent(String query, Consumer<PreparedStatement> con) {
		List<T> content = null;
		try {
			initConnect();
			initPstmt(query, con);
			content = getContentList();
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return content;
	}
	
	public <T> List<T> getJoinedContent(String query, Class<?> joiningClass) {
		List<T> content = null;
		try {
			initConnect();
			initStmt(query);
			content = getJoinedContentList(joiningClass);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return content;
	}
	
	private Map<Class<?>, Method> getRSMethods() {
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

	
	//FIXME delete later
	public List<EmployeesDTO> getEmps(String city) {
		List<EmployeesDTO> list = new ArrayList<>();
		try {
			initConnect();
			String q = "SELECT e.* FROM employees e INNER JOIN departments d ON e.department_id = d.department_id "
					+ "INNER JOIN locations l ON d.location_id = l.location_id "
					+ "WHERE LOWER(l.city) LIKE LOWER(?)";
			initPstmt(q, e -> {
				try {
					e.setString(1, city);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			});
			list = getContentList();
			
			q = "SELECT e.first_name, e.employee_id, e.department_id, d.department_name, l.city, l.location_id "
					+ "FROM employees e "
					+ "INNER JOIN departments d "
					+ "ON d.department_id = e.department_id "
					+ "INNER JOIN locations l "
					+ "ON d.location_id = l.location_id "
					+ "WHERE LOWER(l.city) LIKE LOWER(?)";
			initPstmt(q, e -> {
				try {
					e.setString(1, city);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			});
						
			int i = 0;
			while(rs.next()) {
				DepartmentsDTO dDto = new DepartmentsDTO();
				dDto.setDepartment_id(rs.getInt("department_id"));
				dDto.setDepartment_name(rs.getString("department_name"));
				LocationDTO lDto = new LocationDTO();
				lDto.setLocation_id(rs.getInt("location_id"));
				lDto.setCity(rs.getString("city"));
				
				dDto.setLocationDto(lDto);
				list.get(i).setDeptDTO(dDto);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return list;
	}
	
}
