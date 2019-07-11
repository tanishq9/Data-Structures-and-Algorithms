package DP;

public class minCostPath {
	public static int maze(int[][] m) {
		// Write your code here
		int[][] dp = new int[m.length][m[0].length];
		dp[0][0] = m[0][0];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (i == 0 && j >= 1) {
					dp[0][j] = dp[0][j - 1] + m[0][j];
				} else if (j == 0 && i >= 1) {
					dp[i][0] = dp[i - 1][0] + m[i][0];
				} else if (i >= 1 && j >= 1) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
				}
			}
		}
		return dp[m.length - 1][m[0].length - 1];
	}
}
