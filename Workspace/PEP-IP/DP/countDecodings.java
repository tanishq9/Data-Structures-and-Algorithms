package DP;

public class countDecodings {

	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.charAt(0) == '0') {
			return 0;
		}
		int n = s.length();
		int[] dp = new int[n + 1];
		// meaning of dp[i] : count of decodings of length i
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			int singleContribution = Integer.valueOf(s.substring(i - 1, i));
			int doubleContribution = Integer.valueOf(s.substring(i - 2, i));
			if (singleContribution >= 1 && singleContribution <= 9) {
				dp[i] += dp[i - 1];
			}
			if (doubleContribution >= 10 && doubleContribution <= 26) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[n];
	}

}
