package DP_Revisited;

import java.util.Scanner;

public class jumpGame {
	public static int jump(int[] nums) {
		// Write your code here
		int n = nums.length;
		int[] dp = new int[n];
		dp[n - 1] = 0; // 0 steps to reach last cell from last cell
		for (int i = n - 2; i >= 0; i--) {
			// INT_MAX signifies there is no way from that cell
			dp[i] = Integer.MAX_VALUE;
			int jumpSize = nums[i];
			for (int j = i + 1; j < n && j <= i + jumpSize; j++) {
				dp[i] = Math.min(dp[i], dp[j]);
			}
			if (dp[i] != Integer.MAX_VALUE) {
				dp[i] += 1;
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(dp[i] + " ");
		}
		return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
	}

	// Don't male any changes here
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < num.length; i++) {
			num[i] = s.nextInt();
		}
		System.out.println(jump(num));
	}
}
