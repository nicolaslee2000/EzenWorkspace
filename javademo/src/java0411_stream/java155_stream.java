package java0411_stream;

import java.io.IOException;
import java.io.InputStream;
//carriage return
//line feed
public class java155_stream {
	public static void main(String[] args) {
		InputStream in = System.in;
		
		int data;
		
		try {
			while((data = in.read())!=13){
				System.out.println(data);
				
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
