package DP;

import java.util.Arrays;
import java.util.Comparator;

public class longestChain {
	public int findLongestChain(int[][] pairs) {
		if (pairs == null || pairs.length == 0)
			return 0;

		// end time ke basis pe sort kardo
		// aur start time ka lis nikal lo
		Arrays.sort(pairs, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});
		int omax = Integer.MIN_VALUE;
		int[] dp = new int[pairs.length];
		for (int i = 0; i < pairs.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				// current start > prev end toh pair up
				if (pairs[i][0] > pairs[j][1]) {
					dp[i] = Math.max(dp[i], dp[j]);
				}
			}
			dp[i] += 1;
			omax = Math.max(omax, dp[i]);
		}
		return omax;
	}
}
