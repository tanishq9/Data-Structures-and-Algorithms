package DP;

import java.util.Arrays;

public class LIS {

	static class Pair {
		int index;
		int val;

		Pair(int iindex, int ival) {
			index = iindex;
			val = ival;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
		int[] dp = LIS(arr);
		Pair[] pairArr = new Pair[dp.length];
		for (int i = 0; i < dp.length; i++) {
			pairArr[i] = new Pair(i, dp[i]);
		}
	}

	private static int[] LIS(int[] arr) {
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j])
					dp[i] = Math.max(dp[i], dp[j]);
			}
			dp[i] += 1;
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
		return dp;
	}

}
