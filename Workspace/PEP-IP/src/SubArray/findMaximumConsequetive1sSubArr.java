package SubArray;

public class findMaximumConsequetive1sSubArr {
	public int findMaxConsecutiveOnes(int[] nums) {
		int end = 0;
		int start = 0;
		int len = 0;
		while (end < nums.length) {
			if (nums[end] == 1) {
				// Keep updating length till it is valid
				len = Math.max(len, end - start + 1);
				end++;
				continue;
			} else {
				// Move start and end till its reaches the next valid starting point
				while (start != end) {
					start++;
				}
				end++;
				start++;
			}
		}
		return len;
	}
}
