package DP_Revisited;

import java.util.ArrayList;

public class countCoinChangeCombinations {
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
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= target; j++) {
				if (dp[j - coins[i]] > 0) {
					dp[j] += dp[j - coins[i]];
					for (String prev : list.get(j - coins[i])) {
						list.get(j).add(prev + coins[i]);
					}
				}
			}
		}
		System.out.println(list.get(target));
		return dp[target];
	}
}
