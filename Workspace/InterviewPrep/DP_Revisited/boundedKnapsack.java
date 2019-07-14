package DP_Revisited;

public class boundedKnapsack {
	public static void main(String[] args) {
		int[] wts = { 2, 5, 1, 3, 4 };
		int[] prices = { 15, 14, 10, 45, 30 };
		int capacity = 7;
		System.out.println(bounded(wts, prices, capacity));
	}

	static int bounded(int[] wts, int[] prices, int capacity) {
		int[][] dp = new int[wts.length + 1][capacity + 1];
		// weights vs bag storage matrix
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				// 0 balls or 0 team members considered
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else {
					if (j - wts[i - 1] >= 0) {
						// including our item
						dp[i][j] = dp[i - 1][j - wts[i - 1]] + prices[i - 1];
					}
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
				}

			}
		}
		return dp[wts.length][capacity];
	}

}
