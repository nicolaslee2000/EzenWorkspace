package java0411_stream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class java169_stream {
	public static void main(String[] args) {
		FileReader fr = null;
		RandomAccessFile rf = null;
		File file = new File("src/java0411_stream/song.txt");
		try {
			rf = new RandomAccessFile(file, "rw");
			String stn = new String("\r\nMaron 5 - Daylight, Sunday Moring\r\n");
			rf.seek(rf.length());
			rf.writeUTF(stn);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
