package java0411_stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;

public class java168_stream {
	public static void main(String[] args) {
		FileReader fr = null;
		LineNumberReader nr = null;
		RandomAccessFile rf = null;
		
		try {
			fr  = new FileReader("src/java0411_stream/score.txt");
			nr = new LineNumberReader(fr);
			String line = "";
			rf.seek(0);
			rf.skipBytes(0);
			rf.getFilePointer();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
