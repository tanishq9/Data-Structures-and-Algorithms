package DP;

public class countDecodings2 {
	public int numDecodings(String s) {
		// dp[i] : count of decode ways of all strings s(0:i-1)
		// length 2 => s[0,1] (both inclusive)
		if (s.length() == 0) {
			return 0;
		}
		if (s.charAt(0) == '0') {
			return 0;
		}
		int n = s.length();
		int m = 1000000007;
		long[] dp = new long[n + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '*' ? 9 : 1;
		for (int i = 2; i <= n; i++) {
			char first = s.charAt(i - 1);
			char second = s.charAt(i - 2);
			// Single character contribution
			if (first == '*') {
				dp[i] += 9 * dp[i - 1];
			} else {
				if (first > '0') {
					dp[i] += dp[i - 1];
				}
			}
			// Last two character contribution
			if (second == '*') {
				if (first == '*') {
					dp[i] += 15 * dp[i - 2];
				} else if (first <= '6') {
					dp[i] += 2 * dp[i - 2];
				} else {
					dp[i] += dp[i - 2];
				}
			} else if (second == '1' || second == '2') {
				if (first == '*') {
					if (second == '1') {
						dp[i] += 9 * dp[i - 2];
					} else {
						dp[i] += 6 * dp[i - 2];
					}
				} else if ((first - '0' + (second - '0') * 10) <= 26) {
					dp[i] += dp[i - 2];
				}
			}
			dp[i] %= m;
		}
		return (int) dp[n];
	}
}
