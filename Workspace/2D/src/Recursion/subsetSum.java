package Recursion;

public class subsetSum {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 10, 6 };
		int total = 16;
		System.out.println(numSubsets(arr, total, arr.length - 1));
	}

	private static int numSubsets(int[] arr, int total, int i) {
		if (total == 0) {
			return 1;
		} else if (total < 0) {
			return 0;
		} else if (i < 0) {
			return 0;
		} else if (arr[i] > total) {
			return numSubsets(arr, total, i - 1);
		} else {
			return numSubsets(arr, total - arr[i], i - 1) + numSubsets(arr, total, i - 1);
		}
	}

}
