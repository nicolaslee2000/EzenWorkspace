package java0425_jdbc.part04;

import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcOrm;

public class EmployeesDAO {
	private JdbcOrm dao = JdbcOrm.getInstance(EmployeesDTO.class);
	private static EmployeesDAO emDao = new EmployeesDAO();
	private EmployeesDAO() {};
	
	public static EmployeesDAO getInstance() {
		return emDao;
	}
	
	public List<EmployeesDTO> listMembers() {
		return dao.getContent("SELECT * FROM employees");
	}
	
	public List<EmployeesDTO> searchMembers(String word) {
		return dao.getContent("SELECT * FROM employees WHERE LOWER(first_name) LIKE LOWER(?)", e -> {
			try {
				e.setString(1, "%"+word+"%");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
	}
	
	public List<EmployeesDTO> empDeptLocJoin(String city) {
		return dao.getEmps(city);
	}
}
