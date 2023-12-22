package com.practice.chin.ds.algo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierImpl {

	public static void main(String[] args) {
		
		CyclicBarrier barrier = new CyclicBarrier(3);
		Employee p1 = new Employee("chin",barrier);
		Employee p2 = new Employee("aman",barrier);
		Employee p3 = new Employee("Cleanup",barrier);
		
		new Thread(p1).start();
		new Thread(p2).start();
		new Thread(p3).start();
	}

}

class Employee implements Runnable{
	
	String name;
	CyclicBarrier barrier;
	
	Employee(String name, CyclicBarrier barrier){
		this.name=name;
		this.barrier=barrier;
	}

	@Override
	public void run() {
		System.out.println("Onboarded :"+this.name);
		try {
			int barrier = this.barrier.await();
			if(barrier==0) {
				//cleanup
				System.out.println("Clean up now");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
