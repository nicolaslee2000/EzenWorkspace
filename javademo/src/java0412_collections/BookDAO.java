package java0412_collections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookDAO {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private BookDAO() {

	}

	private static BookDAO dao = new BookDAO();

	public static BookDAO getInstance() {
		return dao;
	}

	
	
}// end class
