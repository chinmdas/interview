package com.practice.chin.atla;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Person {
	
	int age;
	String name;
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}





	public static void main(String[] args) {
		Map<Person,String> map = new HashMap<>();
		Person p1 = new Person(1, "a");
		Person p2 = new Person(1, "a");
		map.put(p1, "p1");
		System.out.println(map.get(p2));
	}

}
