package Array;

import java.util.Arrays;

public class minInToMakeArrUnique {
	public int minIncrementForUnique(int[] A) {
		Arrays.sort(A);
		int res = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] <= A[i - 1]) {
				res += (A[i - 1] - A[i] + 1);
				A[i] = A[i - 1] + 1;
			}
		}
		return res;
	}
}
