package com.practice.chin.ds.algo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExamples {

	public static void main(String[] args) {
		ExecutorService executor1 = Executors.newFixedThreadPool(2);
		ExecutorService executor2 = Executors.newCachedThreadPool();
		ExecutorService executor3 = Executors.newSingleThreadExecutor();
		ScheduledExecutorService executor4 = Executors.newScheduledThreadPool(2);
		for(int i=0;i<50;i++) {
			
			executor1.execute(new Runnable() {

				public void run() {
					System.out.println("Executor service : FixedThreadPool");

				}
			});

			executor2.execute(new Runnable() {

				public void run() {
					System.out.println("Executor service : CachedThreadTool");

				}
			});

			executor3.execute(new Runnable() {

				public void run() {
					System.out.println("Executor service : SingleThreadPool");

				}
			});

			executor4.schedule(new Runnable() {

				public void run() {
					System.out.println("Executor service : ScheduledThreadPool");

				}
			}, 10, TimeUnit.SECONDS);
			
			i++;
		}

	}

}
