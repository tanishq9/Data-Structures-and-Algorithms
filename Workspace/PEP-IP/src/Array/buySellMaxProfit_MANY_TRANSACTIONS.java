package Array;

public class buySellMaxProfit_MANY_TRANSACTIONS {
	// Algorithm : First find the dip and then the max peek for profit
	public int maxProfit(int[] prices) {
		int buyingPoint = -1;
		int sellingPoint = -1;
		int profit = 0;
		int i = 0;
		while (i < prices.length) {
			while ((i + 1) < prices.length && prices[i] > prices[i + 1]) {
				// can't buy at a higher price
				i++;
			}
			buyingPoint = i; // fixed the buying point
			i++; // now find the selling point
			while ((i + 1) < prices.length && prices[i] < prices[i + 1]) {
				i++; // can't sell at a lower profit
			}
			sellingPoint = i; // fixed the selling point
			if (sellingPoint < prices.length && buyingPoint < prices.length) {
				// now compute the profit
				profit += (prices[sellingPoint] - prices[buyingPoint]);
			}
			i++; // Look for more possible buying and selling points
		}
		return profit;
	}
}
