package Array;

import java.util.Arrays;

public class sumOfSubsequenceWidths {
	public static int sumSubseqWidths(int[] A) {
		// Write your code here
		int MOD = 1000000007;
		Arrays.sort(A);
		int n = A.length;
		int res = 0;
		for (int i = 0; i < n; i++) {
			res = (int) (res  + (A[i] * (Math.pow(2, i) - Math.pow(2, n - i - 1))) % MOD);
		}
		return res;
	}

}
