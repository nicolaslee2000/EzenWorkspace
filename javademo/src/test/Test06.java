package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test06 {
	public static void main(String[] args) {
		Test6 t = new Test6();
		t.why();
		Dog aDog = new Dog("Max");
		t.foo(aDog);
		System.out.println(aDog.name);
	}

	
}

class Test6 {
	 List<Integer> list = new ArrayList<>();
	 
	Test6(){
		for(int i = 0; i<5;i++) {
			list.add(i);
		}
	}
	 
	private void removeNum(List<Integer> num) {
		//list.size()==5
		//num.size()==5
		num.add(1);
        this.list.removeAll(num);
        System.out.println(list);//ok
        System.out.println(num);//?????????????????????????
    }
	
	public void why() {
		removeNum(list); 
	}

	 // creating the "Max" dog

	// at this point, aDog points to the "Max" dog

	
	public void foo(Dog someDog) {  // AAA
	    someDog.setName("asdf");     // BBB
	    someDog = new Dog("Fifi");  // CCC
	    someDog.setName("Rowlf");   // DDD
	}
	
}
class Dog{
	String name;
	Dog(String n){
		name = n;
	}
	public void setName(String n) {
		this.name = n;
	}
}
