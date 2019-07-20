package Sorting;

import java.util.Arrays;

public class countInversions {

	static int mergeSortedArrays(int[] arr, int lo, int mid, int hi) {
		int i = lo, j = mid + 1, k = 0;
		int inv_count = 0;
		int[] temp = new int[hi - lo + 1];
		while (i <= mid && j <= hi) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				inv_count += (mid - i + 1);
				temp[k++] = arr[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		while (j <= hi) {
			temp[k++] = arr[j++];
		}
		for (int id = lo; id <= hi; id++) {
			arr[id] = temp[id - lo];
		}
		return inv_count;
	}

	static int sort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			return 0;
		}
		int mid = (lo + ((hi - lo) >> 1));
		int fhalf = sort(arr, lo, mid);
		int rhalf = sort(arr, mid + 1, hi);
		return fhalf + rhalf + mergeSortedArrays(arr, lo, mid, hi);
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 3, 5, 1 };
		System.out.println(sort(arr, 0, arr.length - 1));
		System.out.println(Arrays.toString(arr));
	}
}
