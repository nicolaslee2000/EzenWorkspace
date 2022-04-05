package test;


import java.io.File;
import java.util.HashSet;

public class TestClass2 {
	public static void main(String[] args) {
		A a = new A();
		Object b = a;
		System.out.println(a);
		System.out.println(b);
//		method(b);
		B crap = new B();
		method(crap);
		
		ExamB bb = new ExamB();
		System.out.println(bb instanceof ExamA);
		
		ExamA aa = new ExamA();
		System.out.println(aa instanceof ExamB);
		
		ExamA ea = new ExamB();
		System.out.println(ea instanceof ExamB);
		System.out.println(ea instanceof ExamA);
		System.out.println(ea instanceof ExamC );
		
	}
	public static void method(A a) {
		a.toString();
	}
}
class A extends Object{
	private int bb = 0;
	@Override
	public String toString() {
		return "aaa";
	}
}

class B extends A {
	
}

class ExamA{
	
}
class ExamB extends ExamA{
	
}

class ExamC extends ExamB{
	
}