package test02;

public class Test01 {
	public static void main(String[] args) {
		new vararg().takeInput(1,"asdf",3.3);
	}
}

class vararg {
	vararg() {
		
	}
	public void takeInput(Object... obj) {
		for(Object o : obj) {
			System.out.println(o.getClass().getTypeName());
		}
	}
}