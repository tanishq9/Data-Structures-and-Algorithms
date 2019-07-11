package DP;

public class lengthOfLCIS {
	public int findLengthOfLCIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		int max = 1;
		// dp[i] : longest continuous inc subseq till index i
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				dp[i] = dp[i - 1] + 1;
			} else {
				dp[i] = 1;
			}
			max = Math.max(dp[i], max);
		}
		return max;
	}
}
