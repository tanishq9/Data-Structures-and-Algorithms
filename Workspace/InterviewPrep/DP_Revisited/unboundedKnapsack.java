package DP_Revisited;

public class unboundedKnapsack {
	public static void main(String[] args) {
		int[] wts = { 2, 5, 1, 3, 4 };
		int[] prices = { 15, 14, 10, 45, 30 };
		int capacity = 7;
		System.out.println(unbounded(wts, prices, capacity));
	}

	static int unbounded(int[] wts, int[] prices, int capacity) {
		int[] dp = new int[capacity + 1];
		// dp[i] : max amount that can be formed using given wghts and prices
		for (int i = 1; i <= capacity; i++) {
			for (int j = 0; j < prices.length; j++) {
				if (i >= wts[j]) {
					dp[i] = Math.max(dp[i], dp[i - wts[j]] + prices[j]);
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			System.out.println(dp[i] + " ");
		}
		return dp[capacity];
	}
}
