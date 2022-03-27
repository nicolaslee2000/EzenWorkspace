package test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
	public static void main(String[] args) {
		try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\nicol\\Documents\\converting with java\\Test01.txt")));){
			int a = 0;
			identified:
			while (true) {
				System.out.println(a*10);
				for(int i = 0; i<10;i++) {
					
					try {
						if(i == 3) {
							System.out.println(i);
						}
						else {
							System.out.println(i/0);
						}
						
					} catch (Exception e) {
						System.out.println("error");
						continue;
					}
					System.out.println("breaking");
					break identified;
				}
				a++;
	        }
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
	}
}
