package com.practice.chin.ds.algo;

public class MaximumSumSubarray {
	
	public static void main(String[] args) {
		int arr[]= {-50,3,-1,4,-50,-20};
		int sum = maxSumSubarray(arr);
		System.out.println(sum);
	}

	private static int maxSumSubarray(int[] arr) {
		int sum=arr[0];	
		int maxSum=arr[0];
		int i=1;
		while(i<arr.length) {
			sum+=arr[i];
			sum=Math.max(sum, arr[i]);
			maxSum=Math.max(maxSum, sum);
			i++;
		}
		return maxSum;
	}
	


}
