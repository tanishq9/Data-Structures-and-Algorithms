package DP;

public class uniquePathsWithObstacles {
	public int uniquePathsWithObstacles(int[][] obstacles) {
		int m = obstacles.length;
		int n = obstacles[0].length;
		if (m == 0 && n == 0) {
			return 0;
		}
		if (m == 1 && n == 1) {
			return obstacles[m - 1][n - 1] == 0 ? 1 : 0;
		}
		int[][] dp = new int[m][n];
		// filling up the first row
		for (int col = 0; col < n; col++) {
			if (obstacles[0][col] != 1) {
				dp[0][col] = 1;
			} else {
				break;
			}
		}
		// filling up the first column
		for (int row = 0; row < m; row++) {
			if (obstacles[row][0] != 1) {
				dp[row][0] = 1;
			} else {
				break;
			}
		}
		// general cases
		for (int row = 1; row < m; row++) {
			for (int col = 1; col < n; col++) {
				if (obstacles[row][col] != 1) {
					dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}
