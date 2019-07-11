package DP;

public class countStepsToMinimizeN {
	public static int count_min(int n) {
		// Write your code here
		int[] dp = new int[n + 1];
		dp[1] = 0;
		for (int i = 2; i <= n; i++) {
			// Let us consider -1 gives minimum moves
			dp[i] = dp[i - 1];
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2], dp[i]);
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3], dp[i]);
			}
			dp[i] += 1;
		}
		return dp[n];
	}
}
