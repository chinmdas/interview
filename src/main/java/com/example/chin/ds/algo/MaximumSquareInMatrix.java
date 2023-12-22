package com.practice.chin.ds.algo;

import java.util.Arrays;

public class MaximumSquareInMatrix {

	public static void main(String[] args) {
		int[][] arr = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
		System.out.println(maximalSquare(arr));

	}

	public static int maximalSquare(int[][] matrix) {

		int max = Integer.MIN_VALUE;
		int len = matrix.length;
		int wid = matrix[0].length;

		int[][] dp = new int[len][wid];

		for (int i = len - 1; i >= 0; i--) {
			for (int j = wid - 1; j >= 0; j--) {
				if (matrix[i][j] == 0) {
					dp[i][j] = 0;
				} else if (matrix[i][j] != 0 && (i == len - 1 || j == wid - 1)) {
					dp[i][j] = 1;
				} else {
					int min = Math.min(matrix[i + 1][j], matrix[i][j + 1]);
					min = Math.min(min, matrix[i + 1][j + 1]);
					dp[i][j] = min + 1;
				}

				if (max == Integer.MIN_VALUE) {
					max = dp[i][j];
				} else {
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		System.out.println(Arrays.deepToString(dp));
		return max*max;
	}

}
