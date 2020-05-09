package DP;

import java.util.Arrays;
import java.util.Scanner;

public class pizzaMania {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int x = sc.nextInt();
			int[] dp = new int[501];
			Arrays.fill(dp, Integer.MAX_VALUE);
			int ss = sc.nextInt();
			int ms = sc.nextInt();
			int ls = sc.nextInt();

			dp[ss] = Math.min(dp[ss], sc.nextInt());
			dp[ms] = Math.min(dp[ms], sc.nextInt());
			dp[ls] = Math.min(dp[ls], sc.nextInt());

			for (int i = ss; i <= 500; i++) {
				int s = 1;
				int e = i - 1;
				while (s <= e) {
					if (dp[s] != Integer.MAX_VALUE && dp[e] != Integer.MAX_VALUE) {
						dp[i] = Math.min(dp[i], dp[s] + dp[e]);
					}
					s++;
					e--;
				}
			}

			int min = Integer.MAX_VALUE;
			for (int i = x; i <= 500; i++) {
				min = Math.min(min, dp[i]);
			}
			System.out.println(min);
		}
	}
}
