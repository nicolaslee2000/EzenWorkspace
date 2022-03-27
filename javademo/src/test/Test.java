package test;

import java.io.File;
import java.util.HashSet;

class TestClass {
	HashSet<File> listOfFiles = new HashSet<File>();
	
	//returns all files in the directory as a set
	static HashSet<File> getAllFiles(File file) {
		HashSet<File> listOfFiles = new HashSet<File>();
		if(file.isDirectory()) {
			for(File subFiles : file.listFiles()) {
				if(subFiles.isDirectory()) {
					getAllFiles(subFiles);
				} else {
					listOfFiles.add(subFiles);				
					}
			}
		} else {
			listOfFiles.add(file);				
			}
//		listOfFiles.clear();
		return listOfFiles;
	}
}

public class Test {
	public static void main(String[] args) {
		System.out.println(TestClass.getAllFiles(new File("C:\\Users\\nicol\\Documents\\converting with java\\Testfolder")));
		System.out.println(TestClass.getAllFiles(new File("C:\\Users\\nicol\\Documents\\converting with java\\Testfolder\\javalec\\basic")));
		
		
	}
}