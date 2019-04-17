package DP;

public class permutationCoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 5 };
		int target = 7;
		System.out.println(permute(arr, target));
		System.out.println(comb(arr, target));
	}

	// WATCH PEP VIDEO
	private static int permute(int[] coins, int target) {
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j]) {
					dp[i] += dp[i - coins[j]];
				}
			}
		}
		return dp[target];
	}

	private static int comb(int[] coins, int target) {
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int j = 0; j < coins.length; j++) {
			for (int i = 1; i < dp.length; i++) {
				if (i >= coins[j]) {
					dp[i] += dp[i - coins[j]];
				}
			}
		}
		return dp[target];
	}

}
