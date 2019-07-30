package Sorting;

public class mergeSort {
	static int[] sort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] baseResult = new int[1];
			baseResult[0] = arr[lo];
			return baseResult;
		}
		int mid = (lo + hi) >> 1;
		int[] fhalf = sort(arr, lo, mid);
		int[] shalf = sort(arr, mid + 1, hi);
		int[] sorted = mergeSortedArrays(fhalf, shalf);
		return sorted;
	}

	static int[] mergeSortedArrays(int[] one, int[] two) {
		int[] merged = new int[one.length + two.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				merged[k++] = one[i++];
			} else {
				merged[k++] = two[j++];
			}
		}
		while (i < one.length) {
			merged[k++] = one[i++];
		}
		while (j < two.length) {
			merged[k++] = two[j++];
		}
		return merged;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 3, 1, 2, 4, 8 };
		for (int val : sort(arr, 0, arr.length - 1)) {
			System.out.print(val + " ");
		}

	}
}
