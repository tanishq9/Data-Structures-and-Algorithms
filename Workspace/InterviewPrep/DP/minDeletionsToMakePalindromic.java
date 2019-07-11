package DP;

public class minDeletionsToMakePalindromic {
	public static void mindeletions(String str) {
		// Write your code here
		// FIND LPSQ
		int[][] dp = new int[str.length()][str.length()];
		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = i + gap; j < str.length(); i++, j++) {
				if (gap == 0) {
					dp[i][j] = 1;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = 2;
					} else {
						dp[i][j] = 1;
					}
				} else {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = dp[i + 1][j - 1] + 2;
					} else {
						dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
					}
				}
			}
		}
		// LENGTH - LPSQ
		System.out.println(str.length() - dp[0][str.length() - 1]);
	}
}
