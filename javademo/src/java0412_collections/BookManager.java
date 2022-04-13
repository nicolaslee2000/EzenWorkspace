package java0412_collections;

import java.util.ArrayList;


public class BookManager {
	public static int getRentalPrice(ArrayList<BookDTO> bookList, String kind) {
		// 구현하세요.
		int total = 0;
		for(BookDTO book : bookList) {
			total += book.getKind().equals(kind) ? book.getRentalPrice() : 0;
		}
		
		return total;
	}//end getRentalPrice()
}//end class






