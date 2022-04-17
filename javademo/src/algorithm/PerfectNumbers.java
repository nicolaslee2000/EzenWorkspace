package algorithm;

public class PerfectNumbers {
	public static void main(String[] args) {
		System.out.println(isPerfectNumber(6l));
	}
	
	public static int isPerfectNumber(long num) {
		long sum = 0;
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num%i == 0) {
				sum += i;
			}	
		}
		System.out.println(sum);
		if(sum == num)
			return 1;
		return 0;
	}
}
