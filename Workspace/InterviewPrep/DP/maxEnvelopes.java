package DP;

import java.util.Arrays;
import java.util.Comparator;

public class maxEnvelopes {
	public int maxEnvelopes(int[][] envelopes) {
		Arrays.sort(envelopes, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] < b[0]) {
					return -1;
				} else if (a[0] == b[0]) {
					return b[1] - a[1];
				} else {
					return 1;
				}
			}
		});

		int[] dp = new int[envelopes.length];
		int omax = 0;
		// both width and height have to be compared otherwise won't be able to fit
		// ya fir equal width aur badhi height ho toh usse pehle rakhdo taaki vo baad
		// mei na aaye aur LIS mei consider na ho
		// consider this test case : 1,1 2,3 4,5 4,6 6,7
		// otherwise width aur height dono mei > ka check lagado
		for (int i = 0; i < dp.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
					dp[i] = Math.max(dp[i], dp[j]);
				}
			}
			dp[i] += 1;
			omax = Math.max(omax, dp[i]);
		}
		return omax;
	}
}
