package com.practice.chin.ds.algo;

import java.util.HashMap;
import java.util.Map;

/*
 you have a array, find the subarray whose sum is equal to given sum.
 */
public class SubarrayWithGivenSum {

	public static void main(String[] args) {
		int[] arr = {10,15,-5,15,-10,5};
		int target = 20;
		int[] result = findSubArray(arr,target);
		System.out.println(result[0]+" , "+result[1]);
	}

	private static int[] findSubArray(int[] arr, int target) {
		int[] result = new int[2];
		int currSum=0;
		int start=0;
		int end=-1;
		Map<Integer,Integer> map= new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			currSum+=arr[i];
			if(currSum-target==0) {
				end=i;
				result[0]=start;
				result[1]=end;
				break;
			}
			if(map.get(currSum-target)!=null) {
				start=map.get(currSum-target)+1;
				end=i;
				result[0]=start;
				result[1]=end;
				break;
			}
			map.put(currSum, i);
		}
		
		
		
		return result;
	}

}
