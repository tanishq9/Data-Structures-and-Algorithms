package DP_Pep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class minCoinChange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
		int n = 8098;
		System.out.println(minCoins(n, coins, new int[n + 1]));
		System.out.println(minCoinsBottomUp(n, coins));
	}

	private static int minCoins(int n, int[] coins, int[] dp) {
		if (n == 0) {
			return 0;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		int total = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			if ((n - coins[i]) >= 0) {
				total = Math.min(1 + minCoins(n - coins[i], coins, dp), total);
			}
		}
		return dp[n] = total;
	}

	private static int minCoinsBottomUp(int n, int[] coins) {
		int[] dp = new int[n + 1];
		// dp[i] denotes the minimum number of ways to reach ith cell
		// Initial seed
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i == coins[j]) {
					dp[i] = 1;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if ((i - coins[j]) >= 0) {
					dp[i] = Math.min(min, dp[i - coins[j]]);
				}
			}
			dp[i] += 1;
		}
		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();
		ArrayList<Integer> path = new ArrayList<>();
		for (int i = n; i >= 0;) {
			System.out.println(".... " + i);
			int current = Integer.MIN_VALUE, coin = -1;
			for (int j = 0; j < coins.length; j++) {
				if ((i - coins[j]) >= 0) {
					if ((dp[i] - dp[i - coins[j]]) > current) {
						current = dp[i] - dp[i - coins[j]];
						coin = coins[j];
					}
				}
			}
			path.add(coin);
			i -= coin;
			if (i == 0) {
				break;
			}
		}
		for(int i : path) {
			
		}
		Collections.sort(path,Collections.reverseOrder());
		System.out.println(path);
		return dp[n];
	}
}
