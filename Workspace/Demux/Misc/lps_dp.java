package Recursion_Pep_Online;

public class lps_dp {
	public static void main(String[] args) {
		String str = "abccbc";
		int n = str.length();
		countPalindromicSubstrings(str, n);
		countPalindromicSubsequences(str, n);
	}

	static void countPalindromicSubstrings(String str, int n) {
		boolean[][] ispalin = new boolean[n][n];
		int count = 0;
		for (int gap = 0; gap < n; gap++) {
			for (int i = 0, j = i + gap; j < n; i++, j++) {
				if (gap == 0) {
					ispalin[i][j] = true;
				} else if (gap == 1) {
					ispalin[i][j] = (str.charAt(i) == str.charAt(j));
				} else {
					if (str.charAt(i) == str.charAt(j) && ispalin[i + 1][j - 1] == true) {
						ispalin[i][j] = true;
					}
				}
				if (ispalin[i][j]) {
					count++;
					System.out.println(str.substring(i, j + 1));
				}
			}
		}
		System.out.println(count);
	}

	static void countPalindromicSubsequences(String str, int n) {
		int[][] dp = new int[n][n];
		for (int gap = 0; gap < n; gap++) {
			for (int i = 0, j = i + gap; j < str.length(); i++, j++) {
				if (gap == 0) {
					dp[i][j] = 1;
				} else if (gap == 1) {
					dp[i][j] = (str.charAt(i) == str.charAt(j)) ? 2 : 1;
				} else {
					if (str.charAt(i) == str.charAt(j)) {
						// aba : 0-1 : a,b, 0-2: b,a
						// consider extra b as a(b)a
						// and 1 more due to aa => total 5
						dp[i][j] = 1 + dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1] + dp[i + 1][j - 1];
					} else {
						// abc: a+b+b+c-b
						dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
					}
				}
			}
		}
	}
}
