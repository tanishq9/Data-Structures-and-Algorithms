package Recursion_revisited;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class generateSubsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		generate(nums, 0, new ArrayList<Integer>(), result);
		return result;
	}

	private void generate(int[] nums, int start, List<Integer> temp, List<List<Integer>> result) {
		result.add(new ArrayList<>(temp));
		for (int i = start; i < nums.length; i++) {
			temp.add(nums[i]);
			generate(nums, i + 1, temp, result);
			temp.remove(temp.size() - 1);
		}
	}
}
