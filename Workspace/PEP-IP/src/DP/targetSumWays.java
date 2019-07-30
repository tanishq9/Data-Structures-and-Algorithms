package DP;

import java.util.Arrays;

public class targetSumWays {
	 public int findTargetSumWays(int[] nums, int S) {
	        int[][] memo=new int[nums.length][2001];
	        for(int[] row:memo){
	             Arrays.fill(row, Integer.MIN_VALUE);
	        }
	        return cal(nums,0,0,S,memo);
	    }
	    int cal(int[] nums,int i,int sum,int target,int[][] memo){
	        if(i==nums.length){
	            if(sum==target){
	                return 1;
	            }else{
	                return 0;
	            }
	        }else{
	            if(memo[i][sum+1000]!=Integer.MIN_VALUE){
	                return memo[i][sum+1000];            
	            }
	            int add=cal(nums,i+1,sum+nums[i],target,memo);
	            int subtract=cal(nums,i+1,sum-nums[i],target,memo);
	            memo[i][sum+1000]=add+subtract;
	            return memo[i][sum+1000];
	        } 
	    }
	   
}
