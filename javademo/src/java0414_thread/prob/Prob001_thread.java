package java0414_thread.prob;

import java.util.Stack;

public class Prob001_thread {

	public static void main(String[] args) {	
		Vending vending = new Vending();
		new Consumer(vending).start();
		new Producer(vending).start();
		System.out.println(Thread.currentThread().getName());
	}//end main()

}//end class

class Consumer extends Thread{
	Vending vending;
	Consumer(Vending vending) {
		this.vending = vending;
	}
	
	@Override
	public void run() {
		while(vending.drinks.size()<10) {
			vending.getDrink();
		}
		
	}
}

class Producer extends Thread{
	Vending vending;
	Producer(Vending vending) {
		this.vending = vending;
	}
	@Override
	public void run() {
		while(vending.drinks.size()<10) {
			vending.setDrink();
		}
		
	}
	
}

class Vending {
	Stack<String> drinks;
	Vending() {
		drinks = new Stack<>();
	}
	
	synchronized void getDrink() {

		while(!drinks.isEmpty()) {
			System.out.println("Getting drink no. "+ drinks.size());
			drinks.pop();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	synchronized void setDrink() {
		while(drinks.isEmpty()) {
			System.out.println("Setting drink no. "+ drinks.size());
			drinks.push("A drink");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
			
}




