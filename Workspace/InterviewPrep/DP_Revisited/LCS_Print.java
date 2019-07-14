package DP_Revisited;


public class LCS_Print {
	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "aebd";
		// print lcs
		print(findLCS(str1, str2), str1, str2);
	}

	static void print(int[][] dp, String str1, String str2) {
		int index = dp[dp.length - 1][dp[0].length - 1];
		char[] lcs = new char[index + 1];
		int i = dp.length - 1;
		int j = dp[0].length - 1;
		while (i > 0 && j > 0) {
			// If current character in X[] and Y are same, then
			// current character is part of LCS
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				lcs[--index] = str1.charAt(i - 1);
				i--;
				j--;
			}
			// If not same, then find the larger of two and
			// go in the direction of larger value
			else if (dp[i - 1][j] > dp[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		System.out.println(new String(lcs));
	}

	static int[][] findLCS(String str1, String str2) {
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp;
	}

}
