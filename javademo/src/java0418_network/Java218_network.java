package java0418_network;

import java.net.MalformedURLException;
import java.net.URL;

public class Java218_network {
	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://quarterly.camposanto.com/tagged/fiction");
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			//telnet, ftp, https, http
			System.out.println(url.getProtocol());
			System.out.println(url.getPath());
			System.out.println(url.getQuery());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
