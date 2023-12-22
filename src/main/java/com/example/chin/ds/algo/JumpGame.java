package com.practice.chin.ds.algo;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class JumpGame {

	public static void main(String[] args) {
		int[] arr = {2,3,0,1,4};
		
		System.out.println(jump(arr));
	}

	private static Integer jump(int[] nums) {
		int[] dp = new int[nums.length];
        dp[nums.length-1]=0;
        
        for(int i=nums.length-1;i>=0;i--){
            int min = Integer.MAX_VALUE;
            for(int j=1;j<=nums[i];j++){
                if(i+j<dp.length){
                    min=Math.min(min,dp[i+j]);
                }
            }
            if(min!=Integer.MAX_VALUE){
                dp[i]=1+min;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
	}

}
