package com.practice.chin.ds.algo;

public class PrefixSum {

	public static void main(String[] args) {
		String str = "amazing";
		for(int i=0;i<str.length();i++) {
			if(str.indexOf(str.charAt(i))== str.lastIndexOf(str.charAt(i))) {
				System.out.println(str.charAt(i));
				break;
			}
		}

	}
	
	public static int prefixSum(int[] arr) {
		
		return -1;
	}

}
