package DP_Revisited;

public class targetSum {

	static void target(int[] arr, int target) {
		int[][] dp = new int[arr.length + 1][target + 1];
		// storage[i][j] : If it is possible to reach j target using i players
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				// no players 0 target
				if (i == 0 && j == 0) {
					dp[i][j] = 1;
				}
				// players but 0 target
				if (j == 0 && i >= 1) {
					dp[i][j] = 1;
				}
				// no players and >0 target
				if (i == 0 && j >= 1) {
					dp[i][j] = 0;
				}
				// if we got more than 1 player
				if (i >= 1) {
					if (dp[i - 1][j] == 1) {
						dp[i][j] = 1;
					} else if (j - arr[i - 1] >= 0 && dp[i - 1][j - arr[i - 1]] == 1) {
						dp[i][j] = 1;
					}
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 6, 1 };
		target(arr, 10);
	}
}
