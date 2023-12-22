package com.practice.Interview;

public class AdjecentMaxSum {

	public static void main(String[] args) {
		int[] arr = {4,5,5,10,5,6};
		
		System.out.println(maxNum(arr));

	}

	private static int maxNum(int[] arr) {
		
		int include=arr[0];
		int exclude=0;
		
		for(int i=1;i<arr.length;i++) {
			int inc = Math.max(include, exclude);
			int exc = include+arr[i];
			
			include=inc;
			exclude=exc;
		}
		
		return Math.max(include, exclude);
		
	}

}
