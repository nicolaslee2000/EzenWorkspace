package java0411_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * 직렬화(serializable)
 * 1 객체를 연속적인 데이터로 변환하는 것이다.
 *   반대로는 역직렬화이다.
 * 2 객체의 멤버변수들의 값을 일렬로 나열하는 것이다.
 * 3 객체를 저장하기 위해서는 객체를 직렬화해야 한다.
 * 4 객체를 저장한다는 것은 객체의 멤버변수의 값을 저장한다는 것이다.
 * 5 객체를 직렬화하여 입출력할 수 있는 스트림
 *   ObjectInputStream, ObjectOutputStream
 */
public class java176_stream_serialization {
	public static void main(String[] args) {
		File file = new File("src/java0411_stream/phone.dat");
		
		ObjectOutputStream os = null;
		ObjectInputStream is = null;
		
		try {
			os = new ObjectOutputStream(new FileOutputStream(file));
			Phone p = new Phone("Xiaomi", 9000);
			os.writeObject(p);
			os.writeObject(new String("hi"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			is = new ObjectInputStream(new FileInputStream(file));
			Phone p = (Phone)is.readObject();
			System.out.println(p.toString());
			String sn = (String)is.readObject();
			System.out.println(sn);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class Phone implements Serializable {
	String name;
	int price;
	
	public Phone() {
		
	}
	
	public Phone(String name, int price) {
		this.name= name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return String.format("%s %d\n", name, price);
		
	}
}