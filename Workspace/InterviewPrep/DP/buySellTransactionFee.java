package DP;

public class buySellTransactionFee {
	public int maxProfit(int[] prices, int fee) {
		// [9,1,3,10,1,4,8,6]
		if (prices.length == 0) {
			return 0;
		}
		int buy = -1 * prices[0]; // stands for max amount i can make after buy
		int sell = 0; // stands for max amount that i can make after sell
		for (int i = 1; i < prices.length; i++) {
			int prevb = buy;
			int prevs = sell;
			buy = Math.max(prevb, prevs - prices[i]); // kuch mat karo ya karo
			sell = Math.max(prevs, prevb + prices[i] - fee); // kuch mat karo ya karo
		}
		return sell;
	}
}
