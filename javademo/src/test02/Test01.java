package test02;

import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
		String str = "aaaaaa" + "\n" + "bbbbb" + "\n";
		
		System.out.println(Arrays.toString(str.split("\n")));
		for(String s : str.split("\n")) {
			System.out.println("T"+s+"S");
		}
	}
}
