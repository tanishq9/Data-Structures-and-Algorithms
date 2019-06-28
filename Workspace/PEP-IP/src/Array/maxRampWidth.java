package Array;

public class maxRampWidth {
	public int maxWidthRamp(int[] A) {
		int n = A.length;
		if (n == 1) {
			return 0;
		}
		int[] lmin = new int[n];
		int[] rmax = new int[n];
		lmin[0] = A[0];
		for (int i = 1; i < n; i++) {
			lmin[i] = Math.min(lmin[i - 1], A[i]);
		}
		rmax[n - 1] = A[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rmax[i] = Math.max(rmax[i + 1], A[i]);
		}
		int sp = 0;
		int ep = 0;
		int max = 0;
		while (ep < n) {
			if (lmin[sp] <= rmax[ep]) {
				// Since, it is valid.We update the length.
				max = Math.max(max, ep - sp);
				ep++;
			} else {
				sp++;
			}
		}
		return max;
	}
}
