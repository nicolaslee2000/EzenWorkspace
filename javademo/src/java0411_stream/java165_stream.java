package java0411_stream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class java165_stream {
	public static void main(String[] args) {
		File file = new File("Sample.txt");
		
		FileWriter writer;
		
		try {
			writer = new FileWriter(file, true);
			writer.write("java");
			writer.flush();
			writer.write("lol");
			writer.flush();
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
