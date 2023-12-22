package com.practice.chin.fico;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Test1 {

	public static void main(String[] args) {
		B b = new B();
		Car<String> car = new Car<>();
		Car c= car;
	}

}

class A{
	static {
		System.out.println("static block A");
	}
	{
		System.out.println("Initilizer block A");
	}
	public A() {
		System.out.println("Constructor block A");
	}
	
}

class B extends A{
	static {
		System.out.println("static block B");
		}
		{
			System.out.println("Initilizer block B");
		}
		public B() {
			System.out.println("Constructor block B");
		}
}

class Car<T>{
	void set(T t) {
		
	}

}

