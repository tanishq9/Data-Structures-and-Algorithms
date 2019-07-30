package DP;

public class maxProductSubarray {
	public int maxProduct(int[] nums) {
		int min_so_far = 1;
		int max_so_far = 1;
		int max_overall = Integer.MIN_VALUE;
		for (int val : nums) {
			min_so_far *= val;
			max_so_far *= val;
			int max_temp = Math.max(max_so_far, Math.max(min_so_far, val));
			int min_temp = Math.min(min_so_far, Math.min(max_so_far, val));
			max_so_far = max_temp;
			min_so_far = min_temp;
			max_overall = Math.max(max_overall, max_so_far);
		}
		return max_overall;
	}
}
