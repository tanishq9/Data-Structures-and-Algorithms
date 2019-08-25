package DP_Pep;

public class rodCuttting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
		// System.out.println(numWays(0, price.length));
		System.out.println(rodCutting(price, price.length, new int[price.length + 1]));
		System.out.println(bottomUp(price));

	}

	private static int rodCutting(int[] price, int remainingLength, int[] dp) {
		// dp[i] denotes the maximum profit that I can get by selling ith length piece
		if (remainingLength == 0) {
			return 0;
		}
		if (dp[remainingLength] != 0) {
			return dp[remainingLength];
		}
		int cost = Integer.MIN_VALUE;
		for (int i = 1; i <= price.length; i++) {
			// Always apply the check for negative values otherwise you will have to cover
			// for this case also as a separate base case therefore always do the negative
			// check
			if ((remainingLength - i) >= 0) {
				cost = Math.max(cost, price[i - 1] + rodCutting(price, remainingLength - i, dp));
			}
		}
		return dp[remainingLength] = cost;
	}

	private static int bottomUp(int[] price) {
		int[] dp = new int[price.length + 1];
		// Meaning of cell : each cell tells the maximum profit that we get
		// in selling that ith length i.e dp[i]
		dp[0] = 0;
		for (int i = 1; i <= price.length; i++) {
			dp[i] = price[i - 1];
		}
		for (int i = 1; i <= price.length; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[j] + dp[i - j], dp[i]);
			}
		}
		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();
		return dp[price.length];
	}
}

