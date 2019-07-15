package DP;

public class wiggleSubsequence {
	public int wiggleMaxLength(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int count = 1;
		int prevdiff = 0;
		// Kind of include exclude principle
		// We decide whether we should include the current element to our sequence or
		// not
		for (int i = 1; i <= nums.length - 1; i++) {
			int currdiff = nums[i] - nums[i - 1];
			if ((currdiff > 0 && prevdiff <= 0) || (currdiff < 0 && prevdiff >= 0)) {
				count++;
				prevdiff = currdiff;
			}
		}
		return count;
	}
}
