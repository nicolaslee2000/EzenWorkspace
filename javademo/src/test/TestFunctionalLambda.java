package test;


public class TestFunctionalLambda {
	public static void main(String[] args) {
		Test10 t = new Test10();
		t.checkEven();
		t.checkOdd();
	}
}
class Test10 {
	
	int[] nums = {0,1,2,3,4};
	
	public void checkEven() {
		Check(e -> {if(e%2 == 0) return true;
		return false;});
	}
	
	public void checkOdd() {
		Check(e -> {if(e%2 == 0) return false;
		return true;});
	}
	
	public void Check(i b) {
		for(int num:nums) {
			if(b.check(num)) System.out.println("checksout");
		}
	}
	public interface i{
		boolean check(int number);
	}
}