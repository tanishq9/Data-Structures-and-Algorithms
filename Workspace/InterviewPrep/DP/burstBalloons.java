package DP;

public class burstBalloons {
	public int maxCoins(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		// dp[i][j] in here means, the maximum coins we get after we burst all the
		// balloons between i and j in the original array.

		// https://leetcode.com/problems/burst-balloons/discuss/194608/DP-solution-with-detailed-text-and-video-explanation.
		// 3 1 5 8
		int n = nums.length;
		int[][] dp = new int[n][n];
		for (int gap = 0; gap < n; gap++) {
			for (int i = 0, j = i + gap; j < n; i++, j++) {
				// assume each balloon is burst at the end
				dp[i][j] = Integer.MIN_VALUE;
				for (int k = i; k <= j; k++) {
					// numbers on left ballon and right ballon.
					int LeftFromStart = i == 0 ? 1 : nums[i - 1];
					int LeftFromEnd = j == n - 1 ? 1 : nums[j + 1];
					// left optimized and right optimized
					int left_opt = k == i ? 0 : dp[i][k - 1];
					int right_opt = k == j ? 0 : dp[k + 1][j];
					dp[i][j] = Math.max(dp[i][j], LeftFromStart * nums[k] * LeftFromEnd + left_opt + right_opt);
				}
			}
		}
		return dp[0][n - 1];
	}
}
