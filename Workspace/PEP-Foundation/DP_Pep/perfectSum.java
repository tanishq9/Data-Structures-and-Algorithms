package DP_Pep;

public class perfectSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static int ways(int[] arr, int target) {
		int[][] dp = new int[arr.length + 1][target + 1];
		// Meaning dp[i][j] : number of ways to make sum 'j' using 'i' elements
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = 1;
				} else if (i == 0) {
					dp[i][j] = 0;
				} else if (j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] += dp[i - 1][j];
					if ((j - arr[i - 1]) >= 0) {
						dp[i][j] += dp[i - 1][j - arr[i - 1]];
					}
				}
			}
		}
		return dp[arr.length][target];
	}
}
