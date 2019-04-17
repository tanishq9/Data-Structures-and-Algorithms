package DP;

public class uKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] wts = { 2, 5, 1, 3, 4 };
		int[] prices = { 15, 14, 10, 45, 30 };
		int capacity = 7;
		System.out.println(uknapsack(wts, prices, capacity));
	}

	private static int uknapsack(int[] wts, int[] prices, int capacity) {
		int[] dp = new int[capacity + 1];
		for (int i = 0; i <= capacity; i++) {
			for (int j = 0; j < wts.length; j++) {
				if (i - wts[j] >= 0) {
					dp[i] = Math.max(dp[i], dp[i - wts[j]] + prices[j]);
				}
				// current + rest of team in remaining number of balls
			}
		}
		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();
		return dp[capacity];
	}

}
