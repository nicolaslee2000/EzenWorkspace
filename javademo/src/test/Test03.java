package test;

import java.io.File;
import java.io.IOException;

public class Test03 {
	public static void main(String[] args) {
		new TestClass3();
	}
}

class TestClass3 {
	File root = new File("C:\\Users\\nicol\\Documents\\converting with java\\Testfolder");
	File tg = new File("C:\\Users\\nicol\\Documents\\converting with java\\Testfolder\\Test01.txt");
	File copy = new File("C:\\Users\\nicol\\Documents\\converting with java\\Testfolder - Copy");
	TestClass3() {
		System.out.println(root.getParentFile());
		System.out.println(root.getName());
		File file = new File(root.getParent(),root.getName()+" - Copy");
		
		File f = new File(copy, root.toPath().relativize(tg.toPath()).toString());
		
		try {
			System.out.println("created file" + f);
			System.out.println(tg.toPath());
			System.out.println(root.toPath().relativize(tg.toPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}