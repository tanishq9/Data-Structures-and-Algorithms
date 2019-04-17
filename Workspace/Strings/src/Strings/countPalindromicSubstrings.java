package Strings;

public class countPalindromicSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aba";
		int n = str.length();
		Boolean[][] table = new Boolean[n][n];
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				table[i][j] = false;
				dp[i][j] = 0;
			}
		}

		// All single letters are palindrome
		for (int i = 0; i < str.length(); i++) {
			table[i][i] = true;
			dp[i][i] = 1;
		}
		// All two length substrings
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				table[i][i + 1] = true;
				dp[i][i + 1] = 3;
			} else {
				dp[i][i + 1] = 2;// eg in ab we have 2 palindromic substrings but in aa we have 3 palidromic
									// substrings a,a and aa
			}
		}
		// All 3 or more length substrings
		for (int len = 3; len <= n; len++) {
			// To get the starting index
			for (int start = 0; start < n - len + 1; start++) {
				// Get the ending index
				int end = start + len - 1;
				if (table[start + 1][end - 1] && str.charAt(start) == str.charAt(end)) {
					table[start][end] = true;
				}
				// Add current palindrome substring ( + 1)
				// and rest palinrome substring (dp[i][j-1] + dp[i+1][j])
				// remove common palinrome substrings (- dp[i+1][j-1])
				if (table[start][end] == true) {
					dp[start][end] = dp[start + 1][end] + dp[start][end - 1] - dp[start + 1][end - 1] + 1;
				} else {
					dp[start][end] = dp[start + 1][end] + dp[start][end - 1] - dp[start + 1][end - 1];
				}
			}
		}
		System.out.println(dp[0][n - 1]);
	}
}
