package SubArray;

import java.util.HashMap;

public class largestSubArray01 {
	public int findMaxLength(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		// difference in count and last index
		map.put(0, -1);
		int max = 0;
		int count0 = 0, count1 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				count0++;
			} else {
				count1++;
			}
			int diff = count0 - count1;
			if (map.containsKey(diff)) {
				max = Math.max(max, i - map.get(diff));
			} else {
				map.put(diff, i);
			}
		}
		return max;
	}


}
