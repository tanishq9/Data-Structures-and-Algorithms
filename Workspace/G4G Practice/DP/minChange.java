/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
		int t = sc.nextInt();
		while(t!=0){
		    int n = sc.nextInt();
		    for(int coin : minCoins(n,coins)){
		        System.out.print(coin+" ");
		    }
		    System.out.println();
		    t--;
		}
	}
	private static ArrayList<Integer> minCoins(int n, int[] coins) {
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
		ArrayList<Integer> path = new ArrayList<>();
		for (int i = n; i >= 0;) {
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
		Collections.sort(path,Collections.reverseOrder());
		return path;
	}
}
