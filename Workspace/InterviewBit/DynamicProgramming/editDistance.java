package DynamicProgramming;

public class editDistance {

	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "adc";
		System.out.println(editDistance(str1, str2));
	}

	private static int editDistance(String str1, String str2) {
		if (str1.length() == 0) {
			return str2.length();
		}
		if (str2.length() == 0) {
			return str1.length();
		}
		if (str1.charAt(0) == str2.charAt(0)) {
			return editDistance(str1.substring(1), str2.substring(1));
		}
		int replace = 1 + editDistance(str1.substring(1), str2.substring(1));
		int remove = 1 + editDistance(str1.substring(1), str2);
		int add = 1 + editDistance(str1, str2.substring(1));
		return Math.min(Math.min(replace, remove), add);
	}

	private static int bottomUp(String str1, String str2) {
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		int m = str1.length();
		int n = str2.length();
		dp[0][0] = 0;
		// Filling the dp table as discussed in the approach
		for (int i = 1; i <= n; i++) {
			dp[0][i] = dp[0][i - 1] + 1;// insertion
		}
		for (int i = 1; i <= m; i++) {
			dp[0][i] = dp[0][i - 1] + 1; // deletion
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (str1.charAt(i - 1) != str2.charAt(j - 1)) {
					dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
				} else {
					dp[i][j] = dp[i - 1][j - 1];// No operation
				}
			}
		}
		return dp[str1.length()][str2.length()];
	}

}
