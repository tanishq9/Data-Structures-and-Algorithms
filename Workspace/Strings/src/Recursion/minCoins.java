package Recursion;

public class minCoins {

	public static int minCoins(int[] arr, int amount, int dp[]) {
		if (amount <= 0) {
			return 0;// o rupee ke liye 0 coins
		}
		if (dp[amount] != 0) {
			return dp[amount];
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if ((amount - arr[i]) >= 0) {
				dp[amount - arr[i]] = Math.min(ans, minCoins(arr, amount - arr[i], dp));
				ans = Math.min(dp[amount - arr[i]], ans);
			}
		}
		return ans + 1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 7, 10 };
		int amount = 15;
		int n = 3;
		int[] dp = new int[amount+1];
		System.out.println(minCoins(arr, amount, dp));
	}
}
