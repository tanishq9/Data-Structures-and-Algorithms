package DP;

public class LCS {

	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "aecd";
		System.out.println(lcs(str1, str2));
	}

	private static int lcs(String str1, String str2) {
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else {
					if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					}
				}
			}
		}
		return dp[str1.length()][str2.length()];
	}

}
