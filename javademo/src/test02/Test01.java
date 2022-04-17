package test02;

import java.util.Vector;

public class Test01 {
	public static void main(String[] args) {
		String s = "0= 918.0";
		System.out.println(s.replaceFirst("^\\d.\\s", ""));
	}
}
