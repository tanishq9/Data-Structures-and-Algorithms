package DP_Revisited;

public class minimumPalindromicCut {
	static boolean[][] palindromicSubstrings(String str) {
		boolean[][] dp = new boolean[str.length()][str.length()];
		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = i + gap; j < str.length(); i++, j++) {
				if (gap == 0) {
					dp[i][j] = true;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = true;
					}
				} else {
					if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true) {
						dp[i][j] = true;
					}
				}
			}
		}
		return dp;
	}

	static int mpc(String str) {
		boolean[][] isPalindrome = palindromicSubstrings(str);
		int[][] dp = new int[str.length()][str.length()];
		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = i + gap; j < str.length(); i++, j++) {
				if (gap == 0) {
					dp[i][j] = 0;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = 0;
					} else {
						dp[i][j] = 1;
					}
				} else {
					if (isPalindrome[i][j] == true) {
						dp[i][j] = 0;
					} else {
						dp[i][j] = Integer.MAX_VALUE;
						for (int cut = i; cut <= j - 1; cut++) {
							int factor1 = dp[i][cut];
							int factor2 = dp[cut + 1][j];
							dp[i][j] = Math.min(dp[i][j], factor1 + factor2 + 1);
						}
					}
				}
			}
		}
		return dp[0][str.length() - 1];
	}

	public static void main(String[] args) {
		String str = "abccbc";
		System.out.println(mpc(str));
	}
}
