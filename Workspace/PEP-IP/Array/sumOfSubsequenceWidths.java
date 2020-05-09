package Array;

import java.util.Arrays;

public class sumOfSubsequenceWidths {
	public static int sumSubseqWidths(int[] A) {
		// Write your code here
		int mod = 1000000007;
		Arrays.sort(A);
		int n = A.length;
		long res = 0;

		long[] pow = new long[n];
		pow[0] = 1;
		for (int i = 1; i < n; i++) {
			pow[i] = (pow[i - 1] * 2) % mod;
		}

		for (int i = 0; i < n; i++) {
			res = (res % mod + (A[i] * (pow[i] - pow[n - i - 1])) % mod) % mod;
		}
		return (int) res;
	}

}
