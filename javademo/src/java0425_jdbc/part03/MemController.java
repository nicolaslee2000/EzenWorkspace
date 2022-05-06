package java0425_jdbc.part03;

import java.util.List;


public class MemController {
	MemController() {
		
	}
	public void listMembersProcess() {
		MemDAO dao = MemDAO.getInstance();
//		List<MemDTO> list = dao.listMembers();
//		list.forEach(System.out::println);
		
		dao.insertMembers(new MemDTO("song", 20, "washington"));
	}
}


