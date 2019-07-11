package DP;

public class minOperationsNto0 {
	static void minOperations(int n) {
		// Write your code here
		int[] dp = new int[n + 1];
		dp[n] = 0;
		// smaller problem lies towards my right
		for (int i = n - 1; i >= 0; i--) {
			dp[i] = dp[i + 1];
			if ((i * 2) <= n) {
				dp[i] = Math.min(dp[i], dp[i * 2]);
			}
			dp[i] += 1;
		}
		System.out.println(dp[0]);
	}
}
