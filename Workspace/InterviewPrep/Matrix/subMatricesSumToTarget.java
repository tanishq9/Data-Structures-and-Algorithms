package Matrix;

import java.util.HashMap;

public class subMatricesSumToTarget {
	class Solution {

		// Works in O(n)
		public int numSubmatrixSumTarget(int[][] matrix, int target) {
			// Number of columns
			int n = matrix[0].length;
			// Number of rows
			int m = matrix.length;
			// store the total count of such sub matrices in result variable
			int result = 0;

			// Fix the left boundary
			for (int left = 0; left < n; left++) {
				// Fix the right boundary
				int[] temp = new int[m];
				for (int right = left; right < n; right++) {
					// Compute sum of row elements between the left and right boundary
					for (int k = 0; k < m; k++) {
						temp[k] += matrix[k][right];
					}
					// Check for target sum
					result += subArraySumToTarget(temp, target);
				}
			}
			return result;
		}

		// Works in O(n)
		int subArraySumToTarget(int[] temp, int target) {
			// Use a hashmap of running sum and frequency of that sum
			HashMap<Integer, Integer> map = new HashMap<>();
			int runningSum = 0;
			int count = 0;
			map.put(0, 1);
			for (int i = 0; i < temp.length; i++) {
				runningSum += temp[i];
				if (map.containsKey(runningSum - target)) {
					count += map.get(runningSum - target);
				}
				map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
			}
			return count;
		}

	}
}
