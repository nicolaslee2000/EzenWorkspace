package java0425_jdbc.part04;

import java.util.List;

public class MembersController {
	
	public List<EmployeesDTO> searchProcess(String word) {
		return EmployeesDAO.getInstance().searchMembers(word);
	}
	
	public List<EmployeesDTO> searchAll() {
		return EmployeesDAO.getInstance().listMembers();
	}
	
	public List<EmployeesDTO> empDeptLocJoinProcess(String city)  {
		
		return EmployeesDAO.getInstance().empDeptLocJoin(city);
	}
}
