package Array;

public class shortestUnsortedContinuousArray {
	public int findUnsortedSubarray(int[] nums) {
		int n = nums.length;
		int[] lmax = new int[n];
		int[] rmin = new int[n];
		lmax[0] = nums[0];
		for (int i = 1; i < n; i++) {
			lmax[i] = Math.max(lmax[i - 1], nums[i]);
		}
		rmin[n - 1] = nums[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rmin[i] = Math.min(rmin[i + 1], nums[i]);
		}
		int sp = -1, ep = -1;
		for (int i = 0; i < n; i++) {
			if (lmax[i] > rmin[i]) {
				if (sp == -1) {
					sp = i;
					ep = i;
				} else {
					ep = i;
				}
			}
		}
		if (sp == -1) {
			return 0;
		}
		return ep - sp + 1;
	}
}
