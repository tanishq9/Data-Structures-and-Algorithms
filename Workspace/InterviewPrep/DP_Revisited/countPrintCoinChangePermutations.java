package DP_Revisited;

import java.util.ArrayList;

public class countPrintCoinChangePermutations {
	public static void main(String[] args) {
		int[] coins = { 2, 3, 5, 6 };
		System.out.println(cc(coins, 10));
	}

	static int cc(int[] coins, int target) {
		int[] dp = new int[target + 1];
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		for (int i = 0; i <= target; i++) {
			list.add(new ArrayList<>());
		}
		dp[0] = 1;
		list.get(0).add("");
		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < coins.length; j++) {
				if ((i - coins[j]) >= 0) {
					if (dp[i - coins[j]] >= 0) {
						dp[i] += dp[i - coins[j]];
						for (String prev : list.get(i - coins[j])) {
							list.get(i).add(prev + coins[j]);
						}
					}
				}
			}
		}
		System.out.println(list.get(target));
		return dp[target];
	}
}
