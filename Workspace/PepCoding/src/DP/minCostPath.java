package DP;

public class minCostPath {

	public static void main(String[] args) {
		int[][] arr = { { 2, 4, 0, 3, 1, 7 }, { 1, 0, 2, 7, 4, 2 }, { 3, 6, 1, 0, 3, 9 }, { 8, 3, 8, 1, 6, 5 },
				{ 4, 2, 0, 9, 4, 0 } };
		int[][] arr2 = { { 2, 1, 3 }, { 1, 4, 4 }, { 3, 4, 0 } };
		// Print possible paths using recursion : O(num_paths) not O(2^n)
		printmcp(0, 0, minCost(arr2), "");
	}

	private static int[][] minCost(int[][] cost) {
		int[][] dp = new int[cost.length][cost[0].length];
		dp[0][0] = cost[0][0];
		for (int i = 0; i < cost.length; i++) {
			for (int j = 0; j < cost[0].length; j++) {
				if (i == 0 && j == 0) {
					dp[0][0] = cost[0][0];
				} else if (i == 0) {
					// First Row
					dp[0][j] = cost[0][j] + dp[0][j - 1];
				} else if (j == 0) {
					// First Column
					dp[i][0] = cost[i][0] + dp[i - 1][0];
				} else {
					// Otherwise
					dp[i][j] = cost[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		for (int i = 0; i < cost.length; i++) {
			for (int j = 0; j < cost[0].length; j++) {
				System.out.print(dp[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		return dp;
	}

	private static void printmcp(int r, int c, int[][] dp, String str) {
		if (r == (dp.length - 1) && c == (dp[0].length - 1)) {
			System.out.println(str);
			return;
		}
		if (r == dp.length - 1) {
			printmcp(r, c + 1, dp, str + " " + dp[r][c]);
		} else if (c == dp[0].length - 1) {
			printmcp(r + 1, c, dp, str + " " + dp[r][c]);
		} else {
			if (dp[r][c + 1] < dp[r + 1][c]) {
				printmcp(r, c + 1, dp, str + " " + dp[r][c]);
			} else if (dp[r][c + 1] > dp[r + 1][c]) {
				printmcp(r + 1, c, dp, str + " " + dp[r][c]);
			} else {
				printmcp(r, c + 1, dp, str + " " + dp[r][c]);
				printmcp(r + 1, c, dp, str + " " + dp[r][c]);
			}
		}
	}
}
