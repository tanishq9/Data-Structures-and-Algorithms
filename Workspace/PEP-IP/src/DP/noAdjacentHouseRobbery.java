package DP;

public class noAdjacentHouseRobbery {
	public int rob2var(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int inc = nums[0];
		int exc = 0;
		for (int i = 1; i < nums.length; i++) {
			int previnc = inc;
			int prevexc = exc;
			inc = nums[i] + prevexc;
			exc = Math.max(previnc, prevexc);
		}
		return Math.max(inc, exc);

	}

	static int robberyBottomUpDP(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[1], nums[0]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return dp[n - 1];
	}
}
