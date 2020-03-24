package DP_Pep;

import java.util.Arrays;

public class lis {

	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
		System.out.println(lis(arr));
	}

	private static int lis(int[] arr) {
		int[] dp = new int[arr.length];
		int max = Integer.MIN_VALUE;
		Arrays.fill(dp, 1);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]);	
				}
			}
			dp[i]+=1;
			max=Math.max(dp[i],max);
		}
		return max;
	}
}
