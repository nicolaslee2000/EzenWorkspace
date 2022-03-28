package test;

import java.io.File;
import java.io.IOException;

public class Test04 {
	static File f = new File("C:\\Users\\nicol\\Documents\\converting with java\\Testfolder\\javalec\\basic\\Test05.java");
	public static void main(String[] args) {
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

	
