package jdbc;

public class test03 {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("java.lang.String");
			System.out.println(c.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
