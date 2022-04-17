package java0414_thread.prob;

public class Test02 {
	public static void main(String[] args) {
		Thread thread = new Thread(new MyThread());
		thread.start();
	}
}

class MyThread implements Runnable {
	@Override
	public void run() {
		System.out.println("Running");
	}
}