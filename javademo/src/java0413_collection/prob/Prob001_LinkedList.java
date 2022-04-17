package java0413_collection.prob;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * LinkedList
 * 1 List : 순서적으로 데이터를 저장
 * 2 Stack : LIFO
 * 3 Queue : FIFO
 */

public class Prob001_LinkedList {
	public static void main(String[] args) {
		/*
		 * booklist.txt파일의 데이터를 Stack으로 처리하여 출력되도록 
		 * 프로그램을 구현하시오.
		 *  title             	publisher   writer     price
		 	JSP Programming  	JSPPub     JSPExpert   21000
			Servlet Programming WeBBest 	GoodName	 20000
			JDBC Programming 	JDBCBest 	NaDo SQL 	30000
			SQL Fundmental 		SQLBest		 Na SQL 	47000
			Java Programming 	JavaBest	 Kim kava	 25000
		 */
		String[] ctg = {"title","publisher","writer","price"};
		
		try {
			Files.lines(Paths.get("src\\java0413_collection\\prob\\booklist.txt")).forEach(e -> System.out.println(BookToString(e)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}//end main()
	
	public static String BookToString(String book) {
		String[] bk = book.split("[/]");
		return Arrays.asList(bk).stream().collect(Collectors.joining("  "));
	}
}//end class











