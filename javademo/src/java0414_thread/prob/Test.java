package java0414_thread.prob;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		Thread t1 = new Thread(new Testing(nums), "Firstthread");
		Thread t2 = new Thread(new Testing(nums), "Sirstthread");
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		nums.forEach(System.out::println);
//		new Thread(new Testing(nums), "Secondthread").start();
		
	}
}

class Testing extends Thread{
	ArrayList<Integer> nums;
	
	Testing(ArrayList<Integer> nums) {
		this.nums = nums;
	}
	@Override
	public void run() {
		process(nums);
	}
	void process(ArrayList<Integer> nums) {
		IntStream.range(1, 20).forEach(nums::add);
		
	}
}

class TestingA{
	ArrayList<Integer> nums;
	
	TestingA(ArrayList<Integer> nums) {
		nums.add(20);
		this.nums = nums;
	}
	void Dothing() {
		process(nums);
	}
	void process(ArrayList<Integer> nums) {
		IntStream.range(1, 20).forEach(nums::add);
		
	}
}