package test;

public class Test07 {
	public static void main(String[] args) {
		new Child();
	}
}
class Parent {
	int i = 0;
	void a() {
		i = 10;
	}
}
class Child extends Parent {
	int i = 5;
	Child(){
		a();
		System.out.println(i);
	}
}