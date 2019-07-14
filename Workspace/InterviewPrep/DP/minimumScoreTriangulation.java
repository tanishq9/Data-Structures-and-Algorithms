package DP;

public class minimumScoreTriangulation {
	public static int minScoreTriangulation(int[] A) {
		// Write your code here
		int[][] dp = new int[A.length][A.length];
		for (int g = 2; g < A.length; g++) {
			for (int i = 0, j = i + g; j < A.length; i++, j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i + 1; k <= j - 1; k++) {
					int leftSide = dp[i][k];
					int rightSide = dp[k][j];
					int current = A[i] * A[k] * A[j];
					dp[i][j] = Math.min(dp[i][j], leftSide + rightSide + current);
				}
			}
		}
		return dp[0][A.length - 1];
	}
}
