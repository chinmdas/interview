package com.practice.chin.ds.algo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchImpl {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main starts");
		CountDownLatch countdown = new CountDownLatch(3);
		Producer producer = new Producer(countdown);
		Consumer consumer = new Consumer(countdown);
		Retailer retailer = new Retailer(countdown);
		
		new Thread(producer).start();
		new Thread(retailer).start();
		
		countdown.await();
		
		new Thread(consumer).start();
		System.out.println("Main ends");
	}

}

class Producer implements Runnable{
	CountDownLatch countdown;

	public Producer(CountDownLatch countdown) {
		this.countdown=countdown;
	}

	@Override
	public void run() {
		System.out.println(" Producer Thread finished");
		countdown.countDown();
		System.out.println(countdown.getCount());
	}
	
}

class Retailer implements Runnable{
	CountDownLatch countdown;

	public Retailer(CountDownLatch countdown) {
		this.countdown=countdown;
	}

	@Override
	public void run() {
		System.out.println(" Retailer Thread finished");
		countdown.countDown();
		System.out.println(countdown.getCount());
	}
	
}

class Consumer implements Runnable{
	CountDownLatch countdown;

	public Consumer(CountDownLatch countdown) {
		this.countdown=countdown;
	}

	@Override
	public void run() {
		System.out.println(" Consumer Thread finished");
		countdown.countDown();
		System.out.println(countdown.getCount());
	}
	
}
