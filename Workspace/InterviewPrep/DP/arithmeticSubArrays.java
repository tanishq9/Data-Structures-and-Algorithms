package DP;

public class arithmeticSubArrays {
	public int numberOfArithmeticSlices(int[] A) {
		if (A.length <= 2) {
			return 0;
		}
		int[] dp = new int[A.length];
		int gap = A[1] - A[0];
		for (int i = 2; i < A.length; i++) {
			if ((A[i] - A[i - 1]) == gap) {
				dp[i] = dp[i - 1] + 1;
			} else {
				dp[i] = 0;
				gap = A[i] - A[i - 1];
			}
		}
		int sum = 0;
		for (int i = 0; i < dp.length; i++) {
			sum += dp[i];
		}
		return sum;
	}
}
