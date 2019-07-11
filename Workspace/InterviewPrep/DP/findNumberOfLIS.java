package DP;

public class findNumberOfLIS {
	public int findNumberOfLIS(int[] nums) {
		// length of longest increasing subsequence ending at index i
		int[] lis = new int[nums.length];
		// count of longest increasing subsequence ending at index i
		int[] count = new int[nums.length];
		int result = 0;
		int omax = 0;

		for (int i = 0; i < nums.length; i++) {
			count[i] = 1;
			lis[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j]) {
					if (lis[i] < lis[j] + 1) {
						lis[i] = lis[j] + 1;
						count[i] = count[j];
					} else if (lis[i] == lis[j] + 1) {
						count[i] += count[j];
					}
				}
			}
			if (omax == lis[i]) {
				result += count[i];
			}
			if (omax < lis[i]) {
				omax = lis[i];
				result = count[i];
			}
		}
		return result;
	}
}
