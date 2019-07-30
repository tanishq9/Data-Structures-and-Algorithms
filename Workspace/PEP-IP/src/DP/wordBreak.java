package DP;

import java.util.List;

public class wordBreak {
	public boolean wordBreak_Leet(String s, List<String> wordDict) {
		// dp[i] tells whether we can segment word from [0,i] inclusive of both
		int[] dp = new int[s.length() + 1];
		dp[0] = 1; // we can always segment an empty string i.e [0,0]
		// Now for string of length >=1
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] == 1 && wordDict.contains(s.substring(j, i))) {
					dp[i] = 1;
				}
			}
		}
		return dp[s.length()] == 1;
	}
}
