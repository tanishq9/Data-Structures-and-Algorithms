package Recursion_revisited;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class generateSubsetsNoDupl {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums); // v v imp to sort it before
		generate(nums, 0, new ArrayList<Integer>(), result);
		return result;
	}

	private void generate(int[] nums, int start, List<Integer> temp, List<List<Integer>> result) {
		// v v imp to know what is in level and options
		result.add(new ArrayList<>(temp));
		// har option ke liye dekh ki usse pehle vala option vohi toh nahi
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
			temp.add(nums[i]);
			generate(nums, i + 1, temp, result);
			temp.remove(temp.size() - 1);
		}
	}
}
