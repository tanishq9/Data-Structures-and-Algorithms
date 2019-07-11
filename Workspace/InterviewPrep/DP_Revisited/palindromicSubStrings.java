package DP_Revisited;

public class palindromicSubStrings {
	static int palindromicSubstrings(String str) {
		boolean[][] dp = new boolean[str.length()][str.length()];
		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = i + gap; j < str.length(); i++, j++) {
				if (gap == 0) {
					dp[i][j] = true;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = true;
					}
				} else {
					if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true) {
						dp[i][j] = true;
					}
				}
			}
		}
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				if (dp[i][j] == true) {
					count++;
					System.out.println(i + " " + j);
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String str = "abccbc";
		System.out.println(palindromicSubstrings(str));
	}
}
