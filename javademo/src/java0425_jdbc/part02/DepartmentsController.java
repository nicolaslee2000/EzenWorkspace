package java0425_jdbc.part02;

import java.util.List;

public class DepartmentsController {
	public DepartmentsController() {
		
	}
	
	public void departmentsAllProcess() {
		DepartmentsDAO dao = DepartmentsDAO.getInstance();
		List<DepartmentsDTO> list = dao.getDepartments();
		list.forEach(System.out::println);
	}
	
	public void searchDepartmentsProcess(String str) {
		DepartmentsDAO dao = DepartmentsDAO.getInstance();
		List<DepartmentsDTO> list = dao.searchDepartments("IT");
		list.forEach(System.out::println);
	}
}	
