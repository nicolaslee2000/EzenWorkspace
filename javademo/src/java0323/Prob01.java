package java0323;
/*
 * return 1 if num is factor of 10
 * 
 * testcommit
 * changed to private
 * wtf plz
 */
public class Prob01 {
	static int res;
	public static void main(String[] args) {
		
		factorOfTen(21);
		System.out.println(returnAbsoluteValue(-22));
	}
	
	public static void factorOfTen(int x) {
		
		res = x%10 == 0 ? 1 : 0;
		System.out.println(res);
	}
	
	public static int returnAbsoluteValue(int x) {
		System.out.println(Math.abs(x));
		return x<0 ? x*-1 : x;
		
	}
}
