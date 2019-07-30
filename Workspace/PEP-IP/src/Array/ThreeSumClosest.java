package Array;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int ans = -1;
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int lo = i + 1;
			int hi = nums.length - 1;
			while (lo < hi) {
				int currSum = nums[i] + nums[lo] + nums[hi];
				if (currSum == target) {
					return target;
				} else if (currSum < target) {
					int diff = Math.abs(currSum - target);
					if (minDiff > diff) {
						minDiff = diff;
						ans = currSum;
					}
					while (lo < hi && nums[lo] == nums[lo + 1]) {
						lo++;
					}
					lo++;
				} else {
					int diff = Math.abs(currSum - target);
					if (minDiff > diff) {
						minDiff = diff;
						ans = currSum;
					}
					while (lo < hi && nums[hi] == nums[hi - 1]) {
						hi--;
					}
					hi--;
				}
			}
		}
		return ans;
	}
}
