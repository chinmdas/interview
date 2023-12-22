package com.practice.chin.ds.algo;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5 };
		int amount = 11;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;

		System.out.println(coinChange(arr, amount, dp));

	}

	private static int coinChange(int[] arr, int amount, int[] dp) {
		if (amount == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (amount - arr[i] >= 0) {
				int subAns = 0;
				if (dp[amount - arr[i]] == -1) {
					subAns = coinChange(arr, amount - arr[i], dp);
				} else {
					subAns = dp[amount - arr[i]];
				}
				if (subAns != Integer.MAX_VALUE && subAns+1 < min) {
					min = subAns+1;
				}
			}

		}
		return dp[amount] = min;
	}

}
