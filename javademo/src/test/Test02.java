package test;


import java.io.File;
import java.util.HashSet;

class TestClass2 {
	HashSet<File> listOfFiles = new HashSet<File>();
	
	//returns all files in the directory as a set
	static HashSet<File> getAllFiles(File file) {
	    HashSet<File> set = new HashSet<>();
	    File[] files = file.listFiles();
	    if (files != null) {
	        for (File f : files) {
	            if (f.isDirectory()) {
	                set.addAll(getAllFiles(f));
	            } else {
	                set.add(f);
	            }
	        }
	    }
	    return set;
	}
}

public class Test02 {
	public static void main(String[] args) {
		System.out.println(TestClass2.getAllFiles(new File("C:\\Users\\nicol\\Documents\\converting with java\\Testfolder")));
		System.out.println(TestClass2.getAllFiles(new File("C:\\Users\\nicol\\Documents\\converting with java\\Testfolder\\javalec\\basic")));

	}
}