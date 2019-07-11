package DP_Revisited;

public class palindromicSubsequences {

	static int countPalindromicSubsequences(String str) {
		int[][] dp = new int[str.length()][str.length()];
		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = i + gap; j < str.length(); i++, j++) {
				if (gap == 0) {
					dp[i][j] = 1;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = 3;
					} else {
						dp[i][j] = 2;
					}
				} else {
					if (str.charAt(i) != str.charAt(j)) {
						// abc: a+b+b+c-b
						dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
					} else {
						// aba : 0-1 : a,b, 0-2: b,a
						// consider extra b as a(b)a
						// and 1 more due to aa => total 5
						dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
					}
				}
			}
		}
		return dp[0][str.length() - 1];
	}

	static int longestPalindromicSubsequence(String str) {
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
					if (str.charAt(i) != str.charAt(j)) {
						dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
					} else {
						dp[i][j] = dp[i + 1][j - 1] + 2;
					}
				}
			}
		}
		return dp[0][str.length() - 1];
	}

	public static void main(String[] args) {
		String str = "abccbc";
		System.out.println(countPalindromicSubsequences(str));
		System.out.println(longestPalindromicSubsequence(str));
	}
}
