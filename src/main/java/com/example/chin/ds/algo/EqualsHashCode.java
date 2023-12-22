package com.practice.chin.ds.algo;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class EqualsHashCode {

	public static void main(String[] args) {
		Comparator<Person> comparator = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if(o1.age==o2.age && o1.name.equals(o2.name)) {
					return 0;
				}else if(o1.age>o2.age && o1.name.equals(o2.name)) {
					return 1;
				}else {
					return 0;
				}
				
			}
			
		};
		Set<Person> set = new TreeSet<>(comparator);
		set.add(new Person("john",29));
		set.add(new Person("john",29));
		
		System.out.println(set.size());
	}

}

class Person{
	String name;
	int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age=age;
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
	
	
}
