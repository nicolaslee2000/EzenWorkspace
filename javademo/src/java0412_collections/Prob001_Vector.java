package java0412_collections;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/*
 * [문제] : booklist.txt 파일의 데이터를 이용하여 
 *      책 정보 하나당 하나의 Book 객체를 생성하고 생성된 Book 객체들을 
 *      Vector에 담아서 리턴하는 makeBookList() 메서드를 구현하시오.
 *      
 * [실행결과]
 * Java Programming 의 가격 : 25000
 * SQL Fundamentals 의 가격 : 47000
 * JDBC Programming 의 가격 : 30000
 * Servlet Programming 의 가격 : 20000
 * JSP Programming 의 가격 : 21000
 */
public class Prob001_Vector {

	public static void main(String[] args) {
		Vector<Book> bookList = makeBookList();
		for (Book book : bookList) {
			System.out.println(book.getTitle() + " 의 가격 : " + book.getPrice());
		}

	}// end main()

	private static Vector<Book> makeBookList() {
		// booklist.txt 파일의 데이터를 Vector에 저장한 후 리턴하는 프로그램을 구현하시오.
		File file = new File("src\\java0412_collections\\booklist.txt");
		Vector<Book> books = new Vector<>();
	
		try (BufferedReader reader = new BufferedReader(new FileReader(file));){
			String line;
			while((line = reader.readLine()) != null) {
				String[] arr = line.split("[/]");
				books.add(new Book(arr[0], arr[1], arr[2], arr[3]));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return books;

	}// end makeBookList()

}// end class















