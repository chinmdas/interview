package com.practice.chin.ds.algo;

public class ExtraElementInSecondList {

	public static void main(String[] args) {
		
		int[] arr1= {1,1,2,2,5,7,7};
		
		singleExtraElement(arr1);
		
		int[] arr2= {1,2,5,7,2,7,1,3};
		
		twoDistinctElements(arr2);
		
		int[] arr3= {1,1,1,1,2,2,2,2,5,7,7,7,7};
		singleDistinctElementWithKrepetition(arr3,4);
		
	}
	
	private static void singleDistinctElementWithKrepetition(int[] arr3, int i) {
		int[] bitArr = new int[32];
		
		
		
	}

	private static void twoDistinctElements(int[] arr) {
		int result=0;
		
		for(int i : arr) {
			result^=i;
		}
		
		int setBit = result & -result;
		
		int first=0,second=0;
		
		for(int j : arr) {
			if((setBit & j)>0) {
				first^=j;
			}else {
				second^=j;
			}
		}
		
		System.out.println("first : "+first+" , second : "+second);
		
	}

	public static void singleExtraElement(int[] arr1) {
		int ans=0;
		for(int i : arr1) {
			ans^=i;
		}
		System.out.println("num = "+ans);
	}
}
