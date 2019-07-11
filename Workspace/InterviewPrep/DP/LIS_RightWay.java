package DP;

public class LIS_RightWay {
	public int lengthOfLIS(int[] nums) {
		int[] lis = new int[nums.length];
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			lis[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j]) {
					if (lis[i] < lis[j] + 1) {
						lis[i] = lis[j] + 1;
					}
				}
			}
			max = Math.max(max, lis[i]);
		}
		return max;
	}
}
