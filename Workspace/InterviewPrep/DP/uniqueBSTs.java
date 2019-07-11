package DP;

public class uniqueBSTs {
	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		// g[i]=g[0]*g[n-1] + g[1]*g[n-2] + .... + g[i][n-i]
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				// dp[j-1] is the number of nodes on left side
				// dp[n-j] is the number of nodes on right side
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}
		return dp[n];
	}
}
