package com.practice.chin.ds.algo;

/*
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color. 
The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on

1 5 7
5 8 4
3 2 9
1 2 4

house=4
color=3
*/
public class PaintHouse {

	public static void main(String[] args) {
		int[][] arr = {{1,5,7},{5,8,4},{3,2,9},{1,2,4}};
		
		System.out.println(minimumCostToPaint(arr));

	}

	private static int minimumCostToPaint(int[][] arr) {
		
		int len=arr[0].length;
		int wid=arr.length;
		
		int[][] dp= new int[len][wid];
		
		dp[0][1]=arr[0][1];
		dp[0][2]=arr[0][2];
		dp[0][3]=arr[0][3];
		
		
		for(int house=1;house<wid;house++) {
			dp[house][0]=arr[]
		}
		
		return null;
	}

}
