package com.practice.chin.fico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ThreadSample{
	
	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		queue.add(10);
		queue.add(6);
		queue.add(4);
		queue.add(7);
		queue.add(5);
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
	}
}
