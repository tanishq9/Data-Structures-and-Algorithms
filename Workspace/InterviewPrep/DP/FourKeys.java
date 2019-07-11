package DP;

public class FourKeys {
	public static int maxA(int N) {
		// Write your code here
		int[] dp = new int[N + 1];
		// ACV,ACVV,ACVVV .... find which result yields maximum print
		for (int i = 1; i <= N; i++) {
			if (i <= 6) {
				dp[i] = i;
				continue;
			}
			int m = 2;
			for (int k = i - 3; k >= 1; k--) {
				dp[i] = Math.max(dp[i], m * dp[k]);
				m++;
			}
		}
		return dp[N];
	}
}
