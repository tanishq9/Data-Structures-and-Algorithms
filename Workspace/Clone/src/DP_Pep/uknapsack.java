package DP_Pep;

public class uknapsack {

	public static void main(String[] args) {
		int[] wts = { 2, 5, 1, 3, 4 };
		int[] prices = { 15, 14, 10, 45, 30 };
		int capacity = 7;
		System.out.println(uknap(wts, prices, capacity));
	}

	// Meaning of dp[i] : the max profit that can be earned for capacity 'i'
	
	private static int uknap(int[] wts, int[] prices, int capacity) {
		int[] dp = new int[capacity + 1];
		// by both comb and permute the answer will come out to be the same
		for (int i = 0; i < wts.length; i++) {
			for (int c = 1; c <= capacity; c++) {
				if (c >= wts[i]) {
					dp[c] = Math.max(dp[c], dp[c - wts[i]] + prices[i]);
				}
			}
		}
		for (int i = 0; i <= capacity; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();
		return dp[capacity];
	}

}
