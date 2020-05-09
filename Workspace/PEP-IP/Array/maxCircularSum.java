package Array;

import java.util.Collections;

public class maxCircularSum {
	public static void main(String[] args) {
		int[] arr = { 10, -11, 12 };
		int[] arr2 = { 8, -8, 9, -9, 12, -11, 12 };
		// elements which contribute to the maximum sum are arranged such that
		// wrapping is there
		System.out.println(maxSum(arr2));
	}

	private static int maxSum(int[] arr) {
		// check if all elements are negative
		boolean negative = true;
		int maxNegative = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			maxNegative = Math.max(maxNegative, arr[i]);
			if (arr[i] >= 0) {
				negative = false;
				break;
			}
		}
		if (negative == true) {
			return maxNegative;
		}

		// Find the max out of wrapped contributing elements and non wrapped
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		// Considering max sum is not wrapped around the array
		// I.E continuous sum with array
		int maxNoWrapped = kadane(arr);

		// Negate the array
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1 * arr[i];
		}
		// Get the contribution of non contributing elements by finding their sum
		int maxWrapped = kadane(arr);
		// Remove that sum from total sum to now get the sum of contributing elements
		maxWrapped = sum + maxWrapped;
		return Math.max(maxNoWrapped, maxWrapped);
	}

	private static int kadane(int[] arr) {
		int ms = 0, cs = 0;
		for (int i = 0; i < arr.length; i++) {
			cs += arr[i];
			if (cs < 0) {
				cs = 0;
			}
			ms = Math.max(ms, cs);
		}
		return ms;
	}
}