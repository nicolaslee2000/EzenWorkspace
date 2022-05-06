package jdbc;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import java0425_jdbc.part02.DepartmentsDTO;
import java0425_jdbc.part04.EmployeesDTO;

public class test {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, InstantiationException {
	
		JdbcOrm dao = JdbcOrm.getInstance(Department.class);
		
		String q = "SELECT * FROM departments";
		
//		String q = "SELECT * FROM departments WHERE department_id = ?";
		List<Department> content = dao.getContent(q);
		content.stream().forEach(System.out::println);
		
		
	}
}

class Department {
	int department_id;
	String department_name;
	int location_id;
	public Department() {
		
	}
	public void eat() {
		System.out.println("eating");
	}
	@Override
	public String toString() {
		return "Department [department_id=" + department_id + ", department_name=" + department_name + ", location_id="
				+ location_id + "]";
	}
	
<<<<<<< HEAD
}
=======
	
}
>>>>>>> a645db5f9da84ae5b56d6824431fadda48f5e28d
