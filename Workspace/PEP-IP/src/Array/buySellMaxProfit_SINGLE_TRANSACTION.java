package Array;

public class buySellMaxProfit_SINGLE_TRANSACTION {
	public int maxProfit(int[] prices) {
		int minprice = Integer.MAX_VALUE;
		int maxprofit = 0;
		// find the largest peak following the smallest valley
		// Just keep track of the smallest value in the array
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minprice) {
				minprice = prices[i];
			}
			maxprofit = Math.max(maxprofit, prices[i] - minprice);
		}
		return maxprofit;
	}
}
