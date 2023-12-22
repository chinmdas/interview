package com.practice.chin.atla;

interface Blog{
	default void message() {
		System.out.println("Blog");
	}
	
	public void roam();
}

interface Vlog{

default void message() {
  System.out.println("Vlog");
}
	
}

class Traveller implements Blog,Vlog{

	@Override
	public void roam() {
		System.out.println("Traveller roaming");
		
	}

	@Override
	public void message() {
		Blog.super.message();
	}	
}

public class Default {

	public static void main(String[] args) {
		
		Blog b = new Traveller();
		Vlog b1 = new Traveller();
		b.message();
		b1.message();
	}

}