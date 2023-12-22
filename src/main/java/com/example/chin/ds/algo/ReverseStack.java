package com.practice.chin.ds.algo;

import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack);
		reverseStack(stack);
		printStack(stack);

	}

	private static void printStack(Stack<Integer> stack) {
		System.out.println("Reversed stack");
		System.out.println(stack);
		
	}

	static void reverseStack(Stack<Integer> s) {
		   // base case
		   if(s.empty()) {
		     return;
		   }
		 
		   int element = s.peek();
		   s.pop();
		   reverseStack(s);
		   insertAtBottom(s,element);
		 }

	static void insertAtBottom(Stack<Integer> s, int element) {
		   // base case
		   if(s.empty()) {
		     s.push(element);
		     return;
		   }
		   int topElement = s.peek();
		   s.pop();
		   insertAtBottom(s,element);
		   s.push(topElement);
		 }

}
