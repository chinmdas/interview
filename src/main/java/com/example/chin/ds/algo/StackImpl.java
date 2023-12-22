package com.practice.chin.ds.algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
	Approach:
	a) While add operation do following:
		1) if both the queues are empty, add value in queue1
		2) else which ever queue is empty, add the incoming element into it, and then move all 
		   the data from second queue to this queue
	b) while pop operation, keep polling the data from whichever queue that is non-empty
 *
 */

public class StackImpl {

	public static void main(String[] args) {
		CustomStack stack = new CustomStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}

class CustomStack{
	Queue<Integer> queue1 = new LinkedList<>();
	Queue<Integer> queue2 = new LinkedList<>();
	
	public void push(int element) {
		if(this.queue1.isEmpty() && this.queue2.isEmpty()) {
			this.queue1.add(element);
		} else if(this.queue1.isEmpty()){
			this.queue1.add(element);
			while(!this.queue2.isEmpty()) {
				this.queue1.add(this.queue2.poll());
			}
		}else {
			this.queue2.add(element);
			while(!this.queue1.isEmpty()) {
				this.queue2.add(this.queue1.poll());
			}
		}
		
	}
	
	public int pop() {
		if(this.queue1.isEmpty()) {
			return this.queue2.poll();
		}else {
			return this.queue1.poll();
		}
	}
	
	public boolean isEmpty() {
		return this.queue1.isEmpty() && this.queue2.isEmpty();
	}
}
