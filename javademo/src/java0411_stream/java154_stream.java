package java0411_stream;

import java.io.IOException;
import java.io.InputStream;

public class java154_stream {
	public static void main(String[] args) {
		InputStream in = System.in;	
		
		try {
			int line = in.read();
			System.out.println(line);
			System.out.println((char)line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

