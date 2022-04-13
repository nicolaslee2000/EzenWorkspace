package functionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lambda_exercise_java7 {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carrol", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 38)
        );
		
		people = sortLastName(people);
		printAll(people);
		printC(people);
	}
	
	public static List<Person> sortLastName(List<Person> people) {
		List<String> lastnames = new ArrayList<>();
		List<Person> temp = new ArrayList<>();
		for(Person p : people) {
			lastnames.add(p.getLastName());
		}
		Collections.sort(lastnames);
		for(String ln : lastnames) {
			for(Person p : people) {
				if(p.getLastName().equals(ln))
					temp.add(p);
			}
		}
		return temp;
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

interface workPeople {
	void work();
}



class Person{
	
	String firstName;
	String LastName;
	int age;
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", LastName=" + LastName + ", age=" + age + "]";
	}
	public Person(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}