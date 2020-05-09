package SubArray;

import java.util.HashMap;

public class subArrayWithGivenSum {
	// For revision of approach visit :
	// https://leetcode.com/problems/subarray-sum-equals-k/solution/
	public int subarraySum(int[] nums, int k) {
		int count = 0, sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1); // running sum and frequency
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
	// Algorithm :
	// 1. Update the running sum
	// 2. Increment the count of the k sum sub array if possible
	// 3. Update the map
}
