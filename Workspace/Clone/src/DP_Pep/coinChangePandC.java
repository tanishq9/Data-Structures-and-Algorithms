package DP_Pep;

public class coinChangePandC {

	public static void main(String[] args) {
		int[] coins = { 2, 3, 5, 6 };
		int amount = 10;
		System.out.println(numPermutations(amount, coins));
		System.out.println(numCombinations(amount, coins));
	}

	private static int numCombinations(int amount, int[] coins) {

		int[] dp = new int[amount + 1];
		dp[0] = 1;
		// har coin ka asar daalde one by one
		// taaki bas combination hi generate hoye
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= amount; j++) {
				// 'j' is the current amount which is denoted by dp[j]
				// and 'i' is the index of coin being considered
				dp[j] += dp[j - coins[i]];
			}
		}
		for (int i = 0; i <= amount; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();
		return dp[amount];
	}

	private static int numPermutations(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		// har step mei sabka asar daalte hue chalo
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0) {
					dp[i] = dp[i] + dp[i - coins[j]];
				}
			}
		}
		for (int i = 0; i <= amount; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();
		return dp[amount];
	}

}
