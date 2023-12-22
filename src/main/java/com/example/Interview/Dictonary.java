package com.practice.Interview;

public class Dictonary {

	public static void main(String[] args) {
		
		String str = "walmartisaretailcompany";

		String[] dictionary ={"Walmart", "is", "a", "are", "retail", "com", "company", "any"};
		
		//boolean isValid = checkValidityOfString(str);
		
		int[] arr = {4,5,10,100,10,1,5};
		System.out.println(maxSum(arr));
	}

	private static int maxSum(int[] arr) {
		
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

//	private static boolean checkValidityOfString(String str) {
//		
//		String sample="";
//		for(int i=0;i<str.length();i++) {
//			sample+=str.charAt(i);
//			if(isValid(sample)) {
//				
//			}else {
//				
//			}
//		}
//	}
	
	
	
	
	

}



