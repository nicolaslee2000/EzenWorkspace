package java0413_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Java0413_collection {
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {1,3,5,2,1};
		List<Integer> list = Arrays.asList(arr);
		list.forEach(System.out::println);
		list.sort(new Ascending());
		list.forEach(System.out::println);
		list.sort((a,b) -> b.compareTo(a));
		list.forEach(System.out::println);
	}
}

class Ascending implements Comparator<Integer>{
	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2);
	}
}


class Ascending1 implements Comparator<Number>{
	@Override
	public int compare(Number o1, Number o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}


class Ascending2 implements Comparator<Object>{
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}

class Ascending3 implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}