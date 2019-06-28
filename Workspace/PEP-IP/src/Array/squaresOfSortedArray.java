package Array;

public class squaresOfSortedArray {
	public int[] sortedSquares(int[] A) {
		int lo = 0;
		int hi = A.length - 1;
		int[] op = new int[A.length];
		int index = A.length - 1;
		while (lo <= hi) {
			if (A[lo] * A[lo] > A[hi] * A[hi]) {
				op[index--] = A[lo] * A[lo];
				lo++;
			} else {
				op[index--] = A[hi] * A[hi];
				hi--;
			}
		}
		return op;
	}
}
