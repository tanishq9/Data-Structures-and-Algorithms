package DP_Pep;

public class longestPalindromicSubsequence {

	public static void main(String[] args) {
		String s = "aebcbda";
		System.out.println(lpsq(s));
	}

	private static int lpsq(String s) {
		int[][] strg = new int[s.length()][s.length()];

		// Meaning of strg[i][j] : Count of palindromic subsequence
		// starting from index i and going till index j

		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0, j = i + gap; j < s.length(); i++, j++) {
				if (gap == 0) {
					strg[i][j] = 1;
				} else if (gap == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						strg[i][j] = 2;
					} else {
						strg[i][j] = 1;
					}
				} else {
					if (s.charAt(i) == s.charAt(j)) {
						strg[i][j] = 2 + strg[i + 1][j - 1];
					} else {
						strg[i][j] = Math.max(strg[i][j - 1], strg[i + 1][j]);
					}
				}
			}
		}
		return strg[0][s.length() - 1];
	}

	int countPS(String str) {
		int[][] strg = new int[str.length()][str.length()];
		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = i + gap; j < str.length(); i++, j++) {
				if (gap == 0) {
					strg[i][j] = 1;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						strg[i][j] = 3;
					} else {
						strg[i][j] = 2;
					}
				} else {
					if (str.charAt(i) == str.charAt(j)) {
						strg[i][j] = strg[i + 1][j] + strg[i][j - 1] + 1;
					} else {
						strg[i][j] = strg[i + 1][j] + strg[i][j - 1] - strg[i + 1][j - 1];
					}
				}
			}
		}
		return strg[0][str.length() - 1];
	}
}
