package Sorting;

import java.util.Arrays;

public class quickSort {

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int getPivot(int[] arr, int lo, int hi) {
		int i = lo, j = lo, pivot = arr[hi];
		while (j <= hi - 1) {
			if (arr[j] <= pivot) {
				swap(arr, i, j);
				i++;
			}
			j++;
		}
		swap(arr, i, hi);
		return i;// pivot index
	}

	static void sort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int pivotIndex = getPivot(arr, lo, hi);
		sort(arr, lo, pivotIndex - 1); // smaller
		sort(arr, pivotIndex + 1, hi); // larger
	}

	public static void main(String[] args) {
		int[] arr = { 5, 3, 1, 2, 4, 8 };
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
