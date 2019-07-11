package DP;

public class paintFence {
	public static int CountWays(int n, int k) {
		// Write your code here
		int same = 0;
		int different = k;
		for (int i = 2; i <= n; i++) {
			int prevsame = same;
			int prevdiff = different;
			same = prevdiff;
			different = prevsame * (k - 1) + prevdiff * (k - 1);
		}
		return same + different;
	}
}
