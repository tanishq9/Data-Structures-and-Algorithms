package DP_Pep;

public class knap01 {

	public static void main(String[] args) {
		int[] wts = { 2, 5, 1, 3, 4 };
		int[] prices = { 15, 14, 10, 45, 30 };
		int capacity = 7;
		System.out.println(knapsack(wts, prices, capacity));
	}

	private static int knapsack(int[] wts, int[] prices, int capacity) {
		int[][] table = new int[wts.length + 1][capacity + 1];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				if (i == 0 || j == 0) {
					table[i][j] = 0;
				} else {
					// Considering that element
					if (j - wts[i - 1] >= 0) {
						table[i][j] = table[i - 1][j - wts[i - 1]] + prices[i - 1];
					}
					// NOT Considering that element
					table[i][j] = Math.max(table[i][j], table[i - 1][j]);
				}
			}
		}
		return table[wts.length][capacity];
	}

}
