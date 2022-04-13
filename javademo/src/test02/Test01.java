package test02;

import java.util.Vector;

public class Test01 {
	public static void main(String[] args) {
		Vector<Integer> nums = new Vector<>();
		System.out.println(nums.capacity());
		for(int i = 0; i < 51; i++) {
			nums.add(i);
		}
		System.out.println(nums.capacity());
	}
}
