package java0413_collection;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;

public class Java193_Hashtable {
	public static void main(String[] args) {
		Hashtable<Integer, String> table = new Hashtable<>();
		table.put(10,"java");
		table.put(20, "jsp");
		
		Enumeration<String> enu = table.elements();
		while(enu.hasMoreElements())
			System.out.println(enu.nextElement());
		
		Enumeration<Integer> enuKey = table.keys();
		while(enuKey.hasMoreElements()) {
			Integer key = enuKey.nextElement();
			System.out.println(key+"adfs");
		}
	}
}
