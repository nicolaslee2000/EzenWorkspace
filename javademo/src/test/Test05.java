package test;

import java.io.File;

public class Test05 {
	public static void main(String[] args) {
		File f = new File(System.getProperty("user.home"), "\\Desktop\\Copy");
		f.mkdir();
	}
}