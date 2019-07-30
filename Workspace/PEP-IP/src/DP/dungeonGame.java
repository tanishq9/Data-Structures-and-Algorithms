package DP;

public class dungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		// dp[i][j] represents the minimum health points needed at position (i,j) and
		// the last row or column is just dummy (outside of the range).
		int[][] dp = new int[m + 1][n + 1];
		// initialize the matrix to maximum possible
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		// boundary conditions
		dp[m][n - 1] = 1;
		dp[m - 1][n] = 1;
		// dp[i][j]=max(min(dp[i+1][j],dp[i][j+1])-dungen[i][j],1)
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
				if (dp[i][j] <= 0) {
					dp[i][j] = 1; // minimum 1 point is always needed to reach a cell
				}
			}
		}
		return dp[0][0];
	}
}
