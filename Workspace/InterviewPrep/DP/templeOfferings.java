package DP;

public class templeOfferings {
	private static int totaloffering(int[] height) {
		// Write your code here
		int n = height.length;
		int[] lmax = new int[n];
		lmax[0] = 1;
		for (int i = 1; i < n; i++) {
			if (height[i] > height[i - 1]) {
				lmax[i] = lmax[i - 1] + 1;
			} else {
				lmax[i] = 1;
			}
		}
		int[] rmax = new int[n];
		rmax[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			if (height[i] > height[i + 1]) {
				rmax[i] = rmax[i + 1] + 1;
			} else {
				rmax[i] = 1;
			}
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Math.max(lmax[i], rmax[i]);
		}
		return sum;
	}
}
