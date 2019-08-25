package DP_Pep;

import java.util.HashSet;

public class lcs {

	static HashSet<String> set = null;

	public static void main(String[] args) {
		String str1 = "abcbdab";
		String str2 = "bdcaba";
		int[][] table = lcs(str1, str2);
		set = new HashSet<>();
		printLCS(str1, str2, str1.length(), str2.length(), table);
		for (String s : set) {
			System.out.println(s);
		}
	}

	private static HashSet<String> printLCS(String str1, String str2, int m, int n, int[][] table) {
		if (m == 0 || n == 0) {
			set.add("");
			return set;
		}
		// If last character are same
		if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
			HashSet<String> temp = printLCS(str1, str2, m - 1, n - 1, table);
			for (String s : temp) {
				set.add(s + str1.charAt(m - 1));
			}
		}
		// If not same
		else {
			if (table[m - 1][n] >= table[m][n - 1]) {
				set = printLCS(str1, str2, m - 1, n, table);
			}
			if (table[m - 1][n] <= table[m][n - 1]) {
				HashSet<String> temp = printLCS(str1, str2, m, n - 1, table);
				set.addAll(temp);
			}
		}
		return set;
	}

	private static int[][] lcs(String str1, String str2) {
		int[][] table = new int[str1.length() + 1][str2.length() + 1];
		// Meaning of table[i][j] is the length of longest subsequence
		// if we consider till ith character of string1 ad till jth character of string
		// 2
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				if (i == 0 || j == 0) {
					// if either of the strings are 0 length there no common subsequence
					table[i][j] = 0;
				} else {
					if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
						table[i][j] = table[i - 1][j - 1] + 1;
					} else {
						table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
					}
				}
			}
		}
		return table;
	}

}
