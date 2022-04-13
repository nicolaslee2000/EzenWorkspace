package java0412_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * 2 
 * 10 
 * 4 
 * 6
 */
public class Prob004_ArrayList {

	public static void main(String[] args) {
		int[] arr = { 5, 9, 3, 2, 7 };
		int[] num = { 1, 10, 15, 4, 6 };
		ArrayList<Integer> v = merge(arr, num);
		for (Integer it : v)
			System.out.println(it);
	}// end main()

	public static ArrayList<Integer> merge(int[] arr, int[] num) {
		// arr,num배열을 병합한후 2의 배수만 리턴하는 프로그램을 구현하시오.
		ArrayList<Integer> merged = new ArrayList<>();
		for(int i = 0; i < arr.length + num.length; i++) {
			if(arr[i]%2 == 0)
				merged.add(arr[i]);
			if(num[i]%2 == 0)
				merged.add(num[i]);
		}
		
		return merged;

	}// end merge();

}






