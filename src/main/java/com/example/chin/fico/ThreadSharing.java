package com.practice.chin.fico;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadSharing {
	
	

	public static void main(String[] args) {
		
		QueueClass queueClass = new QueueClass();
		
		Runnable producer = ()-> {
			try {
				queueClass.push();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Runnable consumer = () -> {
			try {
				queueClass.pop();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		new Thread(producer).start();
		new Thread(consumer).start();
	}

}

class QueueClass{
	private Queue<Double> queue = new LinkedList<>();

	public void pop() throws InterruptedException {
		while(true) {
			synchronized(this) {
				if(queue.isEmpty()) {
					System.out.println("Queue is empty: waiting state");
					wait();
				}else {
					notifyAll();
					double val = queue.poll();
					System.out.println("Consumingnvalue : "+val);
				}
			}
			
		}
		
		
	}

	public void push() throws InterruptedException {
		while(true) {
			synchronized(this) {
				if(this.queue.size()>=10) {
					System.out.println("queue is full, waiting ");
					wait();
				}else {
					notifyAll();
					double val = Math.random()*10;
					System.out.println("Adding to queue -> "+val);
					Thread.sleep(10);
					this.queue.add(val);
				}
				
			}
		}
	}
}