package java0418_network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Scanner;
//java.net
//inetaddress


public class Java216_network {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.firewatchgame.com/");
			URLConnection connection = url.openConnection();
			Scanner sc = new Scanner(connection.getInputStream());
//			while(sc.hasNext()) {
//				System.out.println(sc.nextLine());
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			InetAddress ip = InetAddress.getByName("google.com");
			System.out.println(ip.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
