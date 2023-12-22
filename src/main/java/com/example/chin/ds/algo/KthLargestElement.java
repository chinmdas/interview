package com.practice.chin.ds.algo;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {

	public static void main(String[] args) {
		int arr[] = { 5, 67, -1, 10, 17, 4, 23 };
		System.out.println(findKthLargestElement(arr,3));
		System.out.println(findKthLargestElementUsingPriorityQueue(arr,3));
	}

	private static int findKthLargestElementUsingPriorityQueue(int[] arr, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int element : arr) {
			if(queue.size()<k) {
				queue.add(element);
			}else {
				if(queue.peek()<element) {
					queue.poll();
					queue.add(element);
				}
			}
		}
		return queue.poll();
	}

	private static int findKthLargestElement(int[] arr, int k) {
		return arr[find(arr,0,arr.length-1,arr.length-1-k)];
	}

	private static int find(int[] arr, int start, int end, int k) {
		int pivot=end;
		pivot=partition(arr,start,pivot,k);
		if(pivot>k) {
			return find(arr,start,pivot-1,k);
		}else if(pivot<k) {
			return find(arr,pivot+1,end,k);
		}else {
			return pivot;
		}
	}

	private static int partition(int[] arr, int start, int pivot, int k) {
		int pivotElement=arr[pivot];
		int i=0;
		int pivotIndex=0;
		while(i<arr.length-1) {
			if(arr[i]<=pivotElement) {
				swap(arr,i,pivotIndex);
				pivotIndex++;
			}
			i++;
		}
		
		return pivotIndex;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}


}
