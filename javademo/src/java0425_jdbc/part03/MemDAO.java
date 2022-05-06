package java0425_jdbc.part03;

import java.util.List;

import jdbc.JdbcOrm;

public class MemDAO {
	
	private JdbcOrm dao = JdbcOrm.getInstance(MemDTO.class);
	private static MemDAO memDao = new MemDAO();
	private MemDAO() {};
	
	public static MemDAO getInstance() {
		return memDao;
	}
	
	public List<MemDTO> listMembers() {
		return dao.getContent("SELECT * FROM mem");
	}
	
	public int insertMembers(MemDTO dto) {
		int chk = -1;
		dao.insert("mem", dto);
		
		return chk;
	}
	
	public int deleteMembers(int num) {
		int chk = -1;
		return chk;
	}
}
