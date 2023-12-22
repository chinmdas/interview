package com.practice.chin.ds.algo;

import java.util.Arrays;

public class CoinChange2 {

	public static void main(String[] args) {
		int[] arr = {1,2,5};
		int amount =5;
		
		//System.out.println(changePermutation(amount,arr));
		System.out.println(changeCombination(amount,arr));
	}

	public static int changePermutation(int amount, int[] coins) {

		int[] dp = new int[amount + 1];
		dp[0] = 1;

		for (int amt = 1; amt <= amount; amt++) {
			for (int coin : coins) {
				if (coin <= amt) {
					int ramt = amt - coin;
					dp[amt] += dp[ramt];
				}
			}
		}
		
		
		System.out.println(Arrays.toString(dp));

		return dp[amount];
	}
	
	
	public static int changeCombination(int amount, int[] coins) {

		int[] dp = new int[amount + 1];
		dp[0] = 1;

		for(int i=0;i<coins.length;i++) {
			for(int j=1;j<dp.length;j++) {
				if(j>=coins[i]) {
					int remaningAmt=j-coins[i];
					dp[j]+=dp[remaningAmt];
				}
			}
		}
		
		
		System.out.println(Arrays.toString(dp));

		return dp[amount];
	}

}
