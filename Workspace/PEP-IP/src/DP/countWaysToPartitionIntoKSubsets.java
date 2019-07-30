package DP;

public class countWaysToPartitionIntoKSubsets {
	static int countP(int n, int k) {
		// Table to store results of subproblems
		int[][] dp = new int[n + 1][k + 1];

		// Base cases
		for (int i = 0; i <= n; i++)
			dp[i][0] = 0;
		for (int i = 0; i <= k; i++)
			dp[0][k] = 0;

		// Fill rest of the entries in dp[][]
		// in bottom up manner
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= k; j++)
				if (j == 1 || i == j)
					dp[i][j] = 1;
				else
					dp[i][j] = j * dp[i - 1][j] + dp[i - 1][j - 1];

		return dp[n][k];

	}
}
