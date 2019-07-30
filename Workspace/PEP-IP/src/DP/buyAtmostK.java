package DP;

public class buyAtmostK {
	class Solution {
		public int maxProfit(int k, int[] prices) {
			int len = prices.length;
			if (k >= len / 2)
				return quickSolve(prices);

			int[][] dp = new int[k + 1][prices.length];
			for (int i = 1; i <= k; i++) {
				int mindebt = -prices[0];
				for (int j = 1; j < prices.length; j++) {
					// i transactions and j prices
					// dp[i][j] = maximum profit from at most i transactions using prices[0..j]
					dp[i][j] = Math.max(dp[i][j - 1], mindebt + prices[j]);
					mindebt = Math.max(mindebt, dp[i - 1][j - 1] - prices[j]);
					// buy jth tock, to get our debt atithtransaction andjth` stock.
				}
			}
			return dp[k][prices.length - 1];
		}

		private int quickSolve(int[] prices) {
			int len = prices.length, profit = 0;
			for (int i = 1; i < len; i++)
				// as long as there is a price gap, we gain a profit.
				if (prices[i] > prices[i - 1])
					profit += prices[i] - prices[i - 1];
			return profit;
		}
	}
}
