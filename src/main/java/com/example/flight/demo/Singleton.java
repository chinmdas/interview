package com.practice.flight.demo;

import java.util.concurrent.locks.ReentrantLock;

public class Singleton {

	private static Singleton val = null;
	
	static ReentrantLock lock = new ReentrantLock();

	private Singleton() {

	}

	public static Singleton getInstance(){
		
		//lock.lock();
		if(val==null) {
			val= new Singleton();
		}
		//lock.unlock();
		return val;
		
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(()->{
			Singleton s= Singleton.getInstance();
			System.out.println(s.hashCode());
		});
		
		Thread t2 = new Thread(()->{
			Singleton s= Singleton.getInstance();
			System.out.println(s.hashCode());
		});
		
		t1.start();t2.start();
	}
}
