package Array;

import java.util.HashSet;

public class splitArrayWithEqualSum {
	public static boolean splitArray(int[] nums) {
		// LeetCode : 548
		int n = nums.length;

		int[] leftSum = new int[n];
		leftSum[0] = nums[0];
		for (int i = 1; i < n; i++) {
			leftSum[i] = nums[i] + leftSum[i - 1];
		}

		int[] rightSum = new int[n];
		rightSum[n - 1] = nums[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightSum[i] = rightSum[i + 1] + nums[i];
		}
		// [0,i-1]==[i+1,j-1]==[j+1,k-1]==[k+1,n-1]
		for (int j = 3; j <= n - 4; j++) {
			HashSet<Integer> set = new HashSet<>();
			// compute sum of [0,i-1] && [i+1,j-1] parts
			// if they are equal then put them in hashset
			for (int i = 1; i <= j - 2; i++) {
				if (leftSum[i - 1] == leftSum[j - 1] - leftSum[i]) {
					set.add(leftSum[i - 1]);
				}
			}
			for (int k = j + 2; k <= n - 2; k++) {
				if (leftSum[k - 1] - leftSum[j] == rightSum[k + 1] && set.contains(rightSum[k + 1])) {
					return true;
				}
			}
		}
		return false;
	}
}
