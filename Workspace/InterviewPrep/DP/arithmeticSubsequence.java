package DP;

import java.util.HashMap;

public class arithmeticSubsequence {
	public int numberOfArithmeticSlices(int[] A) {
		HashMap[] dp = new HashMap[A.length];
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			// init the current hashmap
			dp[i] = new HashMap<Integer, Integer>();
			for (int j = i - 1; j >= 0; j--) {
				// dynamic 2D array
				// 0 2 3 2 4 : This test case is sufficient to clear logic
				long cd = (long) A[i] - (long) A[j];
				if (cd <= Integer.MIN_VALUE || cd > Integer.MAX_VALUE)
					continue;
				HashMap<Integer, Integer> prev = dp[j];
				int prevContri = (int) dp[j].getOrDefault(cd, 0);
				int currContri = (int) dp[i].getOrDefault(cd, 0);
				count += (prevContri);
				dp[i].put(cd, prevContri + currContri + 1);
			}
		}
		return count;
	}
}
