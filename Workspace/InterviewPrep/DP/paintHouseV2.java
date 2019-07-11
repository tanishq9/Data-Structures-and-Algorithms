package DP;

public class paintHouseV2 {
	public static int minCostII(int[][] costs) {
		// Write your code here
		int[][] dp = new int[costs.length][costs[0].length];
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = costs[0][i];
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < dp[0].length; k++) {
					if (k != j) {
						min = Math.min(min, dp[i - 1][k]);
					}
				}
				dp[i][j] = min + costs[i][j];
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < costs[0].length; i++) {
			ans = Math.min(ans, dp[costs.length - 1][i]);
		}
		return ans;
	}
}
