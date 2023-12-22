package com.practice.chin.ds.algo;

import java.util.Stack;

//Approach
/**
a) add elements to stack1 in push operation
b) in pop operation we should do this everytime:
	step 1. Completely move all the data from stack1 to stack2
	step 2. peek a value from stack2 into a variable which we should return at the end
	step 3. completely move back all the data from stack2 to stack1
**/

public class QueueImpl {

	public static void main(String[] args) {
		CustomQueue queue = new CustomQueue();
		queue.push(13);
		queue.push(1);
		queue.push(4);
		queue.push(7);
		
		while(!queue.isEmpty()) {
			System.out.println(queue.peek());
		}
	}

}

class CustomQueue{
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	
	public void push(Integer item) {
		this.stack1.push(item);
	}
	
	public int pop() {
		while(!this.stack1.isEmpty()) {
			this.stack2.push(this.stack1.pop());
		}
		int value=this.stack2.pop();
		while(!this.stack2.isEmpty()) {
			this.stack1.push(this.stack2.pop());
		}
		return value;
	}
	
	public int peek() {
		while(!this.stack1.isEmpty()) {
			this.stack2.push(this.stack1.pop());
		}
		int value=this.stack2.peek();
		while(!this.stack2.isEmpty()) {
			this.stack1.push(this.stack2.pop());
		}
		return value;
	}
	
	public boolean isEmpty() {
		return this.stack1.isEmpty() && this.stack2.isEmpty();
	}
}
