package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumAllUnique {
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int lo = i + 1;
			int hi = nums.length - 1;
			while (lo < hi) {
				if (nums[lo] + nums[hi] + nums[i] == 0) {
					// add to result
					list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
					while (lo < hi && nums[lo] == nums[lo + 1]) {
						lo++;
					}
					lo++;
					while (lo < hi && nums[hi] == nums[hi - 1]) {
						hi--;
					}
					hi--;
				} else if (nums[lo] + nums[hi] + nums[i] < 0) {
					while (lo < hi && nums[lo] == nums[lo + 1]) {
						lo++;
					}
					lo++;
				} else {
					while (lo < hi && nums[hi] == nums[hi - 1]) {
						hi--;
					}
					hi--;
				}
			}
		}
		return list;
	}
}
