package DP_Revisited;

import java.util.Arrays;
import java.util.Comparator;

public class optimalBST {

	static class Pair {
		int v;
		int f;

		Pair(int iv, int ifr) {
			this.v = iv;
			this.f = ifr;
		}
	}

	public static int optimalCost(int[] val, int[] freq) {
		Pair[] pairs = new Pair[val.length];
		// Form pair of value and frequency
		for (int i = 0; i < val.length; i++) {
			pairs[i] = new Pair(val[i], freq[i]);
		}
		// Sort on basis of value
		/*
		 * Arrays.sort(pairs, new Comparator<Pair>() { public int compare(Pair one, Pair
		 * two) { return one.v - two.v; } });
		 */
		// Compute the prefix sum of frequencies
		int[] prefixSumFreq = new int[freq.length];
		prefixSumFreq[0] = pairs[0].f;
		for (int i = 1; i < prefixSumFreq.length; i++) {
			prefixSumFreq[i] = prefixSumFreq[i - 1] + pairs[i].f;
		}
		int[][] dp = new int[pairs.length][pairs.length];
		for (int gap = 0; gap < pairs.length; gap++) {
			for (int i = 0, j = i + gap; j < pairs.length; i++, j++) {
				if (gap == 0) {
					dp[i][j] = pairs[j].f;
				} else if (gap == 1) {
					int root1 = dp[i][i];
					int root2 = dp[j][j];
					dp[i][j] = Math.min(root1, root2) + root1 + root2;
				} else {
					dp[i][j] = Integer.MAX_VALUE;
					// Consider every value as the possible root
					for (int cut = i; cut <= j; cut++) {
						int leftTree = (cut - 1) < i ? 0 : dp[i][cut - 1];
						int rightTree = (cut + 1) > j ? 0 : dp[cut + 1][j];
						int freqSum = i > 0 ? prefixSumFreq[j] - prefixSumFreq[i - 1] : prefixSumFreq[j];
						dp[i][j] = Math.min(dp[i][j], leftTree + rightTree + freqSum);
					}
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + "\t");
			}
			System.out.println();
		}

		return dp[0][pairs.length - 1];
	}

	public static void main(String[] args) {
		// {10, 12, 20} : keys
		// {34, 8, 50} : value
		// { 1, 4, 5, 2, 8, 7, 6 } : keys
		// { 4, 1, 3, 10, 5, 6, 2 } : value
		int[] val = { 94, 60, 74, 10, 99 };
		int[] freq = { 36, 20, 52, 95, 60 };
		System.out.println(optimalCost(val, freq));
	}

}
