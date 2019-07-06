package Array;

public class maxConsequetiveOnes1 {
	public static int findMaxConsecutiveOnes(int[] nums) {
		// write code here
		int i = 0;
		int j = 0;
		int max = 0;
		int len = 0;
		while (j < nums.length) {
			if (nums[j] == 1) {
				len++;
				max = Math.max(max, len);
			} else {
				// reset
				len = 0;
				while (i != j) {
					i++;
				}
				i++;
			}
			j++;
		}
		return max;
	}
}
