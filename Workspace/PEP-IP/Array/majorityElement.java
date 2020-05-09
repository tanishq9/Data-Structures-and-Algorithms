package Array;

public class majorityElement {
	public static int majorityElementLeet(int[] nums) {
		// Write your code here
		int candidate = -1;
		int votes = 0;
		for (int num : nums) {
			if (votes == 0) {
				candidate = num;
				votes = 1;
				continue;
			}
			if (num == candidate) {
				votes++;
			} else {
				votes--;
			}
		}

		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == candidate) {
				count++;
			}
		}
		return count > nums.length / 2 ? candidate : -1;
	}
}
