package Strings;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// By memoization and takes 0n2 time and space both.

		// table[i][j] will be false if substring str[i..j]
		// is not palindrome.
		// Else table[i][j] will be true
		String str = "forgeeksskeegfor";
		int n = str.length();
		boolean table[][] = new boolean[n][n];

		// Rows denote the

		// All substrings of length 1 are palindromes
		int maxLength = 1;
		for (int i = 0; i < n; ++i)
			table[i][i] = true;

		// check for sub-string of length 2.
		// This is for the range : [i,j] where j-i = 2
		for (int i = 0; i < n - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				table[i][i + 1] = true;
			}
		}
		int start = 0;
		// check for the range of length 3 or more
		// This is for the range : [i,j] where j-i >=3
		for (int len = 3; len < str.length(); len++) {
			// Fix the starting index
			for (int i = 0; i < n - len + 1; i++) {
				// Fix the ending index
				int j = i + len - 1;
				if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
					table[i][j] = true;
					if (len > maxLength) {
						maxLength = len;
						start = i;
					}
				}
			}
		}
		System.out.println(maxLength + " " + str.substring(start, start + maxLength - 1));
	}

}
