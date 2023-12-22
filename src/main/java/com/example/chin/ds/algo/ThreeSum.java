package com.practice.chin.ds.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSum {

	public static void main(String[] args) {
		
		int[] arr = {2,4,5,7,1}; 
		int sum = 8;
		
		System.out.println(Arrays.toString(twoSumWithoutSorting(arr,sum)));
		System.out.println(Arrays.toString(threeSum(arr,sum)));

	}

	private static int[] threeSum(int[] arr, int sum) {
		Arrays.sort(arr);
		int[] result = new int[3];
		for(int i=0;i<arr.length;i++) {
			if(i==0 || arr[i-1]!=arr[1]) {
				result = twoSumWithSorting(i+1,arr.length-1,arr,sum-arr[i]);
			}
		}
		return result;
	}

	private static int[] twoSumWithSorting(int i, int j, int[] arr, int target) {
		int a=arr[i-1];
		int[] result = new int[3];
		while(j>i) {
			if(arr[i]+arr[j]>target) {
				j--;
			}else if(arr[i]+arr[j]<target) {
				i++;
			}else {
				result[0]=a;
				result[1]=arr[i];
				result[2]=arr[j];
				
				break;
			}
		}
		return result;
	}

	private static int[] twoSumWithoutSorting(int[] arr, int sum) {
		Map<Integer,Integer> map = new HashMap<>();
		int[] result = new int[2];
		for(int i=0;i<arr.length;i++) {
			int second = sum-arr[i];
			if(map.isEmpty()) {
				map.put(second, arr[i]);
			}else {
				if(map.get(arr[i])!=null) {
					result[0]=arr[i];
					result[1]=map.get(arr[i]);
					break;
				}else {
					map.put(second, arr[i]);
				}
			}
		}
		
		return result;
	}
	
	

}
