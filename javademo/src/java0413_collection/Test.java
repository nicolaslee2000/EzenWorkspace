package java0413_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test {
	public static void main(String[] args) {
		ArrayList<PersonA> peopleA = new ArrayList<>();
		peopleA.add(new PersonA(20,"Nick"));
		peopleA.add(new PersonA(30,"Jack"));
		peopleA.add(new PersonA(40,"Jack"));
		peopleA.add(new PersonA(10,"Jack"));
		peopleA.add(new PersonA(30,"Andy"));
		peopleA.add(new PersonA(10,"Bev"));
		peopleA.sort(new PersonA());
		peopleA.forEach(System.out::println);
		System.out.println("=========");
		
		
		
		ArrayList<Person> people = new ArrayList<>();
		people.add(new Person(20,"Nick"));
		people.add(new Person(30,"Jack"));
		people.add(new Person(40,"Jack"));
		people.add(new Person(10,"Jack"));
		people.add(new Person(30,"Andy"));
		people.add(new Person(10,"Bev"));
		Collections.sort(people);
		people.forEach(System.out::println);
	}
}

class PersonA implements Comparator<PersonA> {
	int age;
	String name;
	public PersonA() {
		
	}
	
	public PersonA(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "NAME: "+name+" AGE: "+age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int compare(PersonA o1, PersonA o2) {
		if(o1.getName().equals(o2.getName())) {
			return Integer.valueOf(o2.getAge()).compareTo(Integer.valueOf(o1.getAge()));
		} else {
			return o1.getName().compareTo(o2.getName());
		}
	}
}

class Person implements Comparable<Person> {

	int age;
	String name;
	
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "NAME: "+name+" AGE: "+age;
	}
	@Override
	public int compareTo(Person o) {
		if(this.getName().equals(o.getName())) {
			return Integer.valueOf(o.getAge()).compareTo(Integer.valueOf(this.getAge()));
		} else {
			return this.getName().compareTo(o.getName());
		}
	}
	
}