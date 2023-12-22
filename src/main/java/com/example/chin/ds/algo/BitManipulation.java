package com.practice.chin.ds.algo;

import java.util.Arrays;

public class BitManipulation {

	public static void main(String[] args) {
		int[] arr1 = {1,1,4,4,5,5,6,6,7};
		int[] arr2 = {1,1,2,4,4,3,5,5,6,6};
		int[] arr3 = {1,1,1,2,2,2,4,4,4,5,6,6,6};
		
		// when all other numbers are repeated twice apart from a one single number
		System.out.println(findOneNumberWhenOthersRepeatTwice(arr1));
		
		// when all other numbers are repeated twice apart from Two numbers
		int[] result = findTwoNumberWhenOthersRepeatTwice(arr2);
		System.out.println(result[0]+" , "+result[1]);
		
		
		//when all the numbers are repeated K times except One single number

	}
	
	public static int findOneNumberWhenOthersRepeatTwice(int[] arr) {
		int result=0;
		for(int i: arr) {
			result^=i;
		}
		return result;
	}
	
	public static int[] findTwoNumberWhenOthersRepeatTwice(int[] arr) {
		int[] resArr = new int[2];
		Arrays.fill(resArr, 0);
		int result=0;
		for(int i: arr) {
			result^=i;
		}
		
		//to find rightmost set bit
		int setbit= (result & -result);
		
		for(int j: arr) {
			if((j & setbit)>0) {
				resArr[0]^=j;
			}else {
				resArr[1]^=j;
			}
		}
		
		return resArr;
	}

}
