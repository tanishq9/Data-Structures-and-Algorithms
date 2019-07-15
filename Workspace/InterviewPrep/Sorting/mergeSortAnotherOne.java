package Sorting;

import java.util.Arrays;

public class mergeSortAnotherOne {
	static void mergeSortedArrays(int[] arr, int lo, int mid, int hi) {
		int i = lo, k = 0, j = mid + 1;
		int[] temp = new int[hi - lo + 1];
		while (i <= mid && j <= hi) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
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
	}

	static void sort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			return;
		}
		int mid = (lo + ((hi - lo) >> 1));
		sort(arr, lo, mid);
		sort(arr, mid + 1, hi);
		mergeSortedArrays(arr, lo, mid, hi);
	}

	public static void main(String[] args) {
		int[] arr = { 5, 3, 1, 2, 4, 8 };
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
