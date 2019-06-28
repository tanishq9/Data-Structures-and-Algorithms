package Array;

public class maxTurbulentArray {
	public int maxTurbulenceSize(int[] A) {
		int inc = 1, dec = 1;
		int max = 1;
		// we consider the current element as first element of current sequence
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i - 1]) {
				inc = dec + 1;
				dec = 1;
				max = Math.max(max, inc);
			} else if (A[i] < A[i - 1]) {
				dec = inc + 1;
				inc = 1;
				max = Math.max(max, dec);
			} else {
				// equal elements break the sequence
				inc = 1;
				dec = 1;
			}
		}
		return max;
	}
}
