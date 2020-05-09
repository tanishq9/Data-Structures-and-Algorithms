package Matrix;

import java.util.TreeSet;

public class MaxRectangleNoLargerThank {
	public int maxSumSubmatrix(int[][] matrix, int target) {
		int n = matrix[0].length;
		int m = matrix.length;
		int result = Integer.MIN_VALUE;
		// fix the left boundary
		for (int left = 0; left < n; left++) {
			int[] temp = new int[m];
			// fix the right boundary
			for (int right = left; right < n; right++) {
				// System.out.println(left+","+right+" ... ");
				for (int k = 0; k < m; k++) {
					temp[k] += matrix[k][right];
				}
				result = Math.max(result, countSum(temp, target));
			}
		}
		return result;
	}

	// Works in O(nlogn)
	int countSum(int[] arr, int k) {
		TreeSet<Integer> set = new TreeSet<>();
		int runningSum = 0;
		int max = Integer.MIN_VALUE;
		// add 0 to cover single row case
		set.add(0);
		for (int i = 0; i < arr.length; i++) {
			runningSum += arr[i];
			Integer justGreaterThanCeil = set.ceiling(runningSum - k);
			// eg rs=10 and k=5 ke liye we find ceil of 10-5 i.e 5 in set
			// ab set mei jo sabse closest hoga 5 ke vohi ceil hogi
			if (justGreaterThanCeil != null) {
				max = Math.max(max, runningSum - justGreaterThanCeil);
			}
			set.add(runningSum);
		}
		return max;
	}

}
