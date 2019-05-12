package Heap;

public class HeapSort {

	private static void downHeapify(int[] arr, int pi, int sz_heap) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int maxIdx = pi;
		if (lci < sz_heap && arr[lci] > arr[maxIdx]) {
			maxIdx = lci;
		}
		if (rci < sz_heap && arr[rci] > arr[maxIdx]) {
			maxIdx = rci;
		}
		if (maxIdx != pi) {
			swap(arr, maxIdx, pi);
			downHeapify(arr, maxIdx, sz_heap);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void heapSort(int[] arr) {
		// For first time construction
		for (int i = (arr.length / 2) - 1; i >= 0; i--) {
			downHeapify(arr, i, arr.length);
		}
		// Till all the elements are not in their right position
		int cse = 0; // count sorted elements
		while (cse < arr.length - 1) {
			swap(arr, 0, arr.length - 1 - cse);
			cse++;
			downHeapify(arr, 0, arr.length - cse);
		}
	}

	/* --------- Combined HeapSort For 2 Arrays ---------- */

	public static int get(int[] arr1, int[] arr2, int i) {
		if (i < arr1.length) {
			return arr1[i];
		} else {
			return arr2[i - arr1.length];
		}
	}

	public static void set(int[] arr1, int[] arr2, int i, int val) {
		if (i < arr1.length) {
			arr1[i] = val;
		} else {
			arr2[i - arr1.length] = val;
		}
	}

	public static void swapCombined(int[] arr1, int[] arr2, int i, int j) {
		int ith = get(arr1, arr2, i);
		int jth = get(arr1, arr2, j);
		set(arr1, arr2, i, jth);
		set(arr1, arr2, j, ith);
	}

	public static void downHeapifyCombined(int[] arr1, int[] arr2, int pi, int sz_heap) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int maxIdx = pi;
		if (lci < sz_heap && get(arr1, arr2, lci) > get(arr1, arr2, maxIdx)) {
			maxIdx = lci;
		}
		if (rci < sz_heap && get(arr1, arr2, rci) > get(arr1, arr2, maxIdx)) {
			maxIdx = rci;
		}
		if (maxIdx != pi) {
			swapCombined(arr1, arr2, maxIdx, pi);
			downHeapifyCombined(arr1, arr2, maxIdx, sz_heap);
		}
	}

	public static void sortCombined(int[] arr1, int[] arr2) {
		int combinedLength = arr1.length + arr2.length;
		for (int i = (combinedLength / 2) - 1; i >= 0; i--) {
			downHeapifyCombined(arr1, arr2, i, combinedLength);
		}
		combinedLength = arr1.length + arr2.length;
		int cse = 0;
		while (cse < combinedLength - 1) {
			swapCombined(arr1, arr2, 0, combinedLength - 1 - cse);
			cse++;
			downHeapifyCombined(arr1, arr2, 0, combinedLength - cse);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 2, 3, 7, 8, 9, 14 };
		heapSort(arr);
		for (int element : arr) {
			System.out.print(element + " ");
		}
		System.out.println();
		System.out.println();
		int[] arr1 = { 5, 19, 3 };
		int[] arr2 = { 0, 16, 12, 4, -4 };
		sortCombined(arr1, arr2);
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
	}

}
