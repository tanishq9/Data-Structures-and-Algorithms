package DP;

public class deleteAndEarnLeetCode {
	public int deleteAndEarn(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int max = 1;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}
		int[] arr = new int[max + 1];
		for (int i = 0; i < nums.length; i++) {
			arr[nums[i]] += nums[i];
		}
		int inc = arr[1];
		int exc = 0;
		for (int i = 2; i < arr.length; i++) {
			int previnc = inc;
			int prevexc = exc;
			exc = Math.max(previnc, prevexc);
			inc = prevexc + arr[i];
		}
		return Math.max(inc, exc);
	}
}
