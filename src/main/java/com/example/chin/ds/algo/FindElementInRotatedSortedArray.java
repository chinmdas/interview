package com.practice.chin.ds.algo;

public class FindElementInRotatedSortedArray {

	public static void main(String[] args) {
		int[] arr= {40,50,70,10,20,30};
		System.out.println(find(arr,1000));
	}
	
	
	public static int find(int[] arr, int k) {
		
		int start=0;
		int end=arr.length-1;
		
		while(end>=start) {
			int mid=(end+start)/2;
			if(arr[mid]==k) {
				return mid;
			}
			
			if(arr[mid]>arr[start]) {
				//left sub-array sorted
				if(k>=arr[start] && k<arr[mid]) {
					end=mid-1;
				}else {
					start=mid+1;
				}
			}else {
				//right sub-array sorted
				if(k<=arr[end] && k>arr[mid]) {
					start=mid+1;
				}else {
					end=mid-1;
				}
			}
		}
		
		return -1;
	}

}
