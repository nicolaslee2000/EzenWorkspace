package test;

import java.io.File;
import java.util.SortedMap;
import java.util.TreeMap;

public class Test05 {
	public static void main(String[] args) {
		SortedMap<Integer, Integer> map = new TreeMap<>();
		map.put(0, 0);
		map.put(1, 2);
		map.put(1, 3);
		map.put(0, 3);
		map.put(1, 2);
		System.out.println(map.toString());
	}
}