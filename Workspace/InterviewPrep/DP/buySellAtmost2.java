package DP;

public class buySellAtmost2 {
	class Solution {
		public int maxProfit(int[] prices) {
			if (prices.length == 0) {
				return 0;
			}
			// ..pehle pehle tak ka badiya..) (...baad baad tak ka badiya..
			int[] lmax = new int[prices.length];
			// lmax[i] denotes what is the best profit that I can earn by selling ON or
			// BEFORE this point
			// isse pehle pehle ka badiya
			int[] rmax = new int[prices.length];
			// rmax[i] denotes what is the best profit that I can earn by buying ON or AFTER
			// this point
			// isse baad baad ka badiya
			int minSoFar = prices[0];
			int maxSoFar = prices[prices.length - 1];
			for (int i = 1; i < prices.length; i++) {
				minSoFar = Math.min(minSoFar, prices[i]);
				lmax[i] = Math.max(prices[i] - minSoFar, lmax[i - 1]);
			}
			for (int i = prices.length - 2; i >= 0; i--) {
				maxSoFar = Math.max(maxSoFar, prices[i]);
				rmax[i] = Math.max(maxSoFar - prices[i], rmax[i + 1]);
			}
			int maxProfit = 0;
			for (int i = 0; i < prices.length; i++) {
				System.out.print(lmax[i] + " ");
			}
			System.out.println();
			for (int i = 0; i < prices.length; i++) {
				System.out.print(rmax[i] + " ");
			}
			for (int i = 0; i < prices.length; i++) {
				maxProfit = Math.max(maxProfit, lmax[i] + rmax[i]);
			}
			return maxProfit;
		}
	}
}
