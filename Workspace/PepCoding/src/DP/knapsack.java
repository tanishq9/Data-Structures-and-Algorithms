package DP;

public class knapsack {

	public static void main(String[] args) {
		int[] wts = { 2, 5, 1, 3, 4 };
		int[] prices = { 15, 14, 10, 45, 30 };
		int capacity = 7;
		System.out.println(knapsack(wts, prices, capacity));
	}

	private static int knapsack(int[] wts, int[] prices, int capacity) {
		int[][] dp = new int[prices.length + 1][capacity + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				// 0 balls or 0 team members considered
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else {
					if (j - wts[i - 1] >= 0) {
						dp[i][j] = prices[i - 1] + dp[i - 1][j - wts[i - 1]];
					}
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + "\t");
			}
			System.out.println();
		}
		return dp[prices.length][capacity];
	}

}
