package com.practice.chin.atla;

import java.util.ArrayList;
import java.util.List;

public class Practice {
	public static int j=1;
	public static void main(String[] args) throws InterruptedException {
		Practice p = new Practice();
		Thread t1= new Thread(()->p.print(1));
		Thread t2= new Thread(()->p.print(2));
		Thread t3= new Thread(()->p.print(3));
		
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
	}
	
	public void print(int val) {
		synchronized(this) {
			System.out.println("thread-"+val+ " printing : "+j);
			j++;
			notifyAll();
		}
	}

}
