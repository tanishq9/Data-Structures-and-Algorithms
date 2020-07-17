package Recursion_Pep_Online;

public class min_palin_cut {
	public static void main(String[] args) {
		String str = "abccbc";
		int[][] dp = new int[str.length()][str.length()];
		System.out.println(cuts(str, 0, str.length() - 1, dp));
		System.out.println(cutsBottomUp(str));
	}

	static int counter = 0;

	static int cuts(String str, int si, int ei, int[][] dp) {
		if (isPalin(str, si, ei)) {
			return 0;
		}
		if (dp[si][ei] != 0) {
			return dp[si][ei];
		}
		// System.out.println(counter++);
		int min = Integer.MAX_VALUE;
		// cp : cut point
		for (int cp = si; cp < ei; cp++) {
			int leftPartCuts = cuts(str, si, cp, dp);
			int rightPartCuts = cuts(str, cp + 1, ei, dp);
			int totalCuts = leftPartCuts + rightPartCuts + 1;
			min = Math.min(min, totalCuts);
		}
		dp[si][ei] = min;
		return min;
	}

	static boolean isPalin(String str, int si, int ei) {
		int left = si;
		int right = ei;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	static int cutsBottomUp(String str) {
		boolean[][] isPalindrome = new boolean[str.length()][str.length()];
		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = i + gap; j < str.length(); i++, j++) {
				if (gap == 0) {
					isPalindrome[i][j] = true;
				} else if (gap == 1) {
					isPalindrome[i][j] = (str.charAt(i) == str.charAt(j));
				} else {
					if (str.charAt(i) == str.charAt(j) && isPalindrome[i + 1][j - 1]) {
						isPalindrome[i][j] = true;
					}
				}
			}
		}

		int[][] dp = new int[str.length()][str.length()];
		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = i + gap; j < str.length(); i++, j++) {
				if (gap == 0) {
					dp[i][j] = 0;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = 0;
					} else {
						dp[i][j] = 1;
					}
				} else {
					if (isPalindrome[i][j]) {
						dp[i][j] = 0;
					} else {
						int min = Integer.MAX_VALUE;
						for (int cp = i; cp <= j - 1; cp++) {
							int lp = dp[i][cp];
							int rp = dp[cp + 1][j];
							min = Math.min(min, lp + rp + 1);
						}
						dp[i][j] = min;
					}
				}
			}
		}
		return dp[0][str.length() - 1];
	}

}
