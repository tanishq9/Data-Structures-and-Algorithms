package DP;

public class buySellCooldown {
	public int maxProfit(int[] prices) {
		// [9,1,3,10,1,4,8,6]
		if (prices.length == 0) {
			return 0;
		}
		int buy = -1 * prices[0];
		int sell = 0;
		int cooldown = 0;
		for (int i = 1; i < prices.length; i++) {
			int prevb = buy;
			int prevs = sell;
			int prevc = cooldown;
			// buy only after cooldown - kuch mat karo ya karo
			buy = Math.max(prevb, cooldown - prices[i]);
			// sell - kuch karo ya kuch mat karo
			sell = Math.max(prevs, prevb + prices[i]);
			// cooldown - karo karo ya kuch mat karo
			cooldown = Math.max(prevc, prevs);
		}
		return sell;
	}
}
