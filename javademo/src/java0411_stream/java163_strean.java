package java0411_stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class java163_strean {
	public static void main(String[] args) {
		InputStream in = System.in;
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		try {
			String data = reader.readLine();
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
