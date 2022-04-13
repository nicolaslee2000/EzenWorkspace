package java0413_collection;

import java.util.Iterator;
import java.util.TreeSet;

public class Java192_TreeSet {
	public static void main(String[] args) {
		TreeSet<Integer> tree = new TreeSet<>();
		tree.add(10);
		tree.add(40);
		tree.add(20);
		tree.add(30);
		tree.add(20);
		//ascending order
		tree.forEach(System.out::println);
		
		//descending
		Iterator<Integer> it = tree.descendingIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
