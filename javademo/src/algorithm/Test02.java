package algorithm;

import java.util.Arrays;

public class Test02 {
	public static void main(String[] args) {
		int[] a = new int[18];
		for(int i = 0; i < 18; i++) {
			a[i] = i;
		}
		for(int i:a) {
			System.out.println(i%3);
		}
	}
}
