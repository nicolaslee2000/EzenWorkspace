package algorithm;

public class swapWithoutThridVar {
	public static void main(String[] args) {
		int a = 5;
		int b = 7;
		swap(a,b);
		
	}
	public static void swap(int a, int b) {
		a = a+b;
		b = a-b;
		a = a-b;
		System.out.println(a);
		System.out.println(b);
	}
}
