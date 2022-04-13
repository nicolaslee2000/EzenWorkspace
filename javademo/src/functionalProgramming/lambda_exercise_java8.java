package functionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class lambda_exercise_java8 {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carrol", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 38)
        );
		
		Collections.sort(people, (a,b) -> a.getLastName().compareTo(b.getLastName()));
		Consumer<Person> printAll = p -> System.out.println(p);
		Consumer<Person> printC = p -> {if(p.getLastName().startsWith("C")) System.out.println(p);};
		printLambda(printAll, people);
		printLambda(printC, people);
		
//		printC(people);
	}
	
	public static void printLambda(Consumer<Person> con, List<Person> people) {
		for(Person p : people) {
			con.accept(p);
		}
	}
	


	
	public static void printAll(List<Person> people) {
		for(Person p : people) {
			System.out.println(p.toString());
		}
	}
	
	public static void printC(List<Person> people) {
		for(Person p: people ) {
			if(p.getLastName().startsWith("C"))
				System.out.println(p.toString());
		}
	}
}

