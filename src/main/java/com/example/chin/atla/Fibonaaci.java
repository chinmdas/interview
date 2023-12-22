package com.practice.chin.atla;

public class Fibonaaci {
	//1,1,2,3,5,8,13
	int prev=0;
	public static void main(String[] args) {
		int max=10;
		for(int i=0;i<max;i++) {
			System.out.println(fibonaci(i));
		}
	}
	
	public static int fibonaci(int n) {
		if(n==0) {
			return 0;
		}
		if(n==1 || n==2) {
			return 1;
		}
		
		return fibonaci(n-2)+fibonaci(n-1);
	}

}

























