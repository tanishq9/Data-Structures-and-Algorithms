package Array;

public class seperateDuplicatesArray {
	public int removeDuplicates(int[] nums) {
		int i = 0; // isse pehle saare duplicates hai
		int j = 1;
		while (j < nums.length) {
			if (nums[i] == nums[j]) {
				j++;
			} else {
				nums[++i] = nums[j++];
			}
		}
		return i + 1;
	}
}
