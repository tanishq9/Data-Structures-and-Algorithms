package Strings;

public class lcsIterative {

	public static void main(String[] args) {
		String str1 = "abdd";
		String str2 = "abdd";
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		// i is the length of the first string and j is the length of the second string
		// we start filling the table from the bottom
		for (int i = str1.length() - 1; i >= 0; i--) {
			for (int j = str2.length() - 1; j >= 0; j--) {
				if (i == str1.length()) {
					dp[i][j] = 0;
					continue;
				}
				if (j == str2.length()) {
					dp[i][j] = 0;
					continue;
				}
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = 1 + dp[i + 1][j + 1];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		System.out.println(dp[0][0]);
	}

}
