package DP_Revisited;

public class maximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0) {
			return 0;
		}
		long[][] dp = new long[matrix.length][matrix[0].length];
		long max = 0;
		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[0].length - 1; j >= 0; j--) {
				if (i == matrix.length - 1) {
					dp[i][j] = matrix[i][j] - '0';
				} else if (j == matrix[0].length - 1) {
					dp[i][j] = matrix[i][j] - '0';
				} else {
					// if top left is 1 then only a matrix of all 1s can be formed
					if (matrix[i][j] == '1') {
						dp[i][j] = 1 + Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
					}
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		return (int) (max * max);
	}
}
