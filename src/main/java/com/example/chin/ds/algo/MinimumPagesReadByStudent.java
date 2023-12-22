package com.practice.chin.ds.algo;

public class MinimumPagesReadByStudent {

	public static void main(String[] args) {
		int[] arr = {10,10,20,30};
		int k=2;
		
		System.out.println(minimize(arr,k));

	}

	private static int minimize(int[] arr, int k) {
		
		int min=0;
		int max=0;
		for(int i=0;i<arr.length;i++) {
			min=Math.min(min, arr[i]);
			max+=arr[i];
		}
		int result=0;
		while(min<=max) {
			int mid=(max+min)/2;
			if(feasible(arr,k,mid)) {
				result=mid;
				max=mid-1;
			}else {
				min=mid+1;
			}
		}
		return result;
	}

	private static boolean feasible(int[] arr, int k, int mid) {
		
		int student=1;
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			if(sum+arr[i]>mid) {
				student++;
				sum=arr[i];
			}else {
				sum+=arr[i];
			}
		}
		
		return student<=k;
	}

}
