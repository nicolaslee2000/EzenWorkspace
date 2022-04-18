package java0418_network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Java219_ClientSocket {
	public static void main(String[] args) {
		//request server
		try {
			Socket socket = new Socket("127.0.0.1", 7777);
			InputStream input = socket.getInputStream();
			OutputStream output = socket.getOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(output);
			
			writer.write("sending information");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
