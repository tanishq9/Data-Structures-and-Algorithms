package Misc;

public class maxVotes_MajorityElement {
	public int majorityElement(int[] nums) {
		// Kind of a voting strategy
		int votes = 0;
		int candidate = -1;
		for (int num : nums) {
			if (votes == 0) {
				candidate = num;
			}
			if (num == candidate) {
				votes++;
			} else {
				votes--;
			}
		}
		return candidate;
	}
}
