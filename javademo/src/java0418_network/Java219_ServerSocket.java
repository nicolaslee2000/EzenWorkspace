package java0418_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Java219_ServerSocket {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("Waiting");
			
			Socket socket = server.accept();
			
			InputStream input = socket.getInputStream();
			OutputStream output = socket.getOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(output);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			System.out.println(reader.readLine());
			writer.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
