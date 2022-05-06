package java0425_jdbc.part04;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class EmpMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.println("search first name");
//		String word = sc.nextLine();
		
//		List<EmployeesDTO> list = new MembersController().searchProcess(word);
//		if(list.isEmpty()) {
//			System.out.println("no match");
//		}
//		list.forEach(e -> System.out.printf(
//				"%d %s %.2f %s\n", e.getEmployee_id(), e.getFirst_name(), 
//				e.getSalary(), new SimpleDateFormat("dd-MM-yyyy").format(e.getHire_date())
//				));
		System.out.println("search city");
		String city = sc.nextLine();
		List<EmployeesDTO> list = new MembersController().empDeptLocJoinProcess(city);
		list.forEach(e -> System.out.println(e + "====" + e.getDeptDTO().getDepartment_id()+"====="+e.getDeptDTO().getLocationDto().getCity()));
		
		sc.close();
	}
}
