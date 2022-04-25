package jdbc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class test {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, InstantiationException {
	
		DAO dao = DAO.getInstance(Department.class);
		String q = "SELECT * FROM departments";
		List<Object> content = dao.getContent(q);
		content.stream().forEach(System.out::println);
		
		
//		abstract class mammal implements animal {}
//		Class<?> resultSet = mammal.class;
//		Method[] methods = resultSet.getMethods();
//		Object chi = Chi.class.getDeclaredConstructor().newInstance();
//		resultSet.getMethod("eat").invoke(chi);
//		
//		Field field = chi.getClass().getDeclaredField("name");
//		field.setAccessible(true);
//		field.set(chi, resultSet.getMethod("eat").invoke(chi));
//		System.out.println(chi.getClass().getDeclaredField("name").get(chi));
		
	}

}

class Department {
	int department_id;
	String department_name;
	int location_id;
	public Department() {
		
	}
	@Override
	public String toString() {
		return "Department [department_id=" + department_id + ", department_name=" + department_name + ", location_id="
				+ location_id + "]";
	}
	
	
}
interface animal {
	String eat();
}
class dog implements animal {
	public String eat() {
		return "banana";
	}
}
class Chi extends dog {
	String name;
}