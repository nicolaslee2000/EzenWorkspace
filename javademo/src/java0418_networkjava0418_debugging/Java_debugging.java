package java0418_networkjava0418_debugging;

public class Java_debugging {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			System.out.println(i);
			sum+= count(i);
		}
	}
	public static int count(int index) {
		int[] num = new int[] {1,5,2,3,4};
		return num[index];
	}
}
