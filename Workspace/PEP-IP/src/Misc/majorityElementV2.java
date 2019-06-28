package Misc;

import java.util.ArrayList;
import java.util.List;

public class majorityElementV2 {
	class Solution {
		public List<Integer> majorityElement(int[] nums) {
			List<Integer> result = new ArrayList<Integer>();
			if (nums.length == 0 || nums == null) {
				return result;
			}
			int candidate1 = -1, candidate2 = -1, count1 = 0, count2 = 0;
			for (int num : nums) {
				if (num == candidate1) {
					count1++;
				} else if (num == candidate2) {
					count2++;
				} else if (count1 == 0) {
					candidate1 = num;
					count1 = 1;
				} else if (count2 == 0) {
					candidate2 = num;
					count2 = 1;
				} else {
					// Decrease votes of both candidates
					count1--;
					count2--;
				}
			}
			count1 = 0;
			count2 = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == candidate1) {
					count1++;
				} else if (nums[i] == candidate2) {
					count2++;
				}
			}
			if (count1 > nums.length / 3) {
				result.add(candidate1);
			}
			if (candidate1 != candidate2 && count2 > nums.length / 3) {
				result.add(candidate2);
			}
			return result;
		}
	}
}
