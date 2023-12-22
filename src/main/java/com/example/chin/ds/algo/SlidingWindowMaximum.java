package com.practice.chin.ds.algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };

		System.out.println(slidingWindowPriorityQueue(arr, 3));
		System.out.println(slidingWindowMaxDeque(arr, 3));

	}

	private static List<Integer> slidingWindowPriorityQueue(int[] nums, int k) {

		List<Integer> result = new ArrayList<>();

		for (int i = 0; i <= nums.length - k; i++) {
			int elementToRemove = 0; // this will store the first element that we want to remove
			PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
			for (int j = i; j < i + k; j++) {
				if (i == j) {
					elementToRemove = nums[j];
				}
				queue.add(nums[j]);
			}
			int element = queue.peek();
			result.add(element);
			queue.remove(elementToRemove);//remove the first element
			elementToRemove = 0;
		}
		return result;
	}
	
	
	private static List<Integer> slidingWindowMaxDeque(int[] nums, int k) {

		Deque<Integer> deque = new ArrayDeque<>();
		List<Integer> result = new ArrayList<>();
		
		for(int i=0;i<=nums.length-k;i++) {
			int elementToRemove=nums[i];
			for(int j=0;j<k;j++) {
				if(deque.isEmpty()) {
					deque.add(nums[i+j]);
				}else {
					while(!deque.isEmpty() && deque.getLast()<nums[i+j]) {
						deque.removeLast();
					}
					deque.addLast(nums[i+j]);
				}
			}
			result.add(deque.getFirst());
			deque.remove(elementToRemove);
		}
		
		return result;
	}

}
