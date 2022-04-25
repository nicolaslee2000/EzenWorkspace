package java0425_jdbc.part02;

/*
 * MVC pattern
 * 
 * Model
 * View
 * Controller
 */
public class Java222_jdbc {
	public static void main(String[] args) {
//		new DepartmentsController().departmentsAllProcess();
		new DepartmentsController().searchDepartmentsProcess("%IT%");
	}
}
