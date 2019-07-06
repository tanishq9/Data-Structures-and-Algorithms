package Heap;

public class heapSort {
	static public void sort(int arr[]) {
		// first time construction
		// initially all the elements are considered to be part of the heap
		for (int i = (arr.length - 1) / 2; i >= 0; i--) {
			heapify(arr, i, arr.length);
		}
		int cse = 0; // count of sorted elements
		while (cse < arr.length - 1) {
			swap(arr, 0, arr.length - 1 - cse);
			cse++;
			heapify(arr, 0, arr.length - cse);
		}
	}

	static void heapify(int arr[], int pi, int sz_heap) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int maxidx = pi;
		if (lci < sz_heap && arr[lci] > arr[maxidx]) {
			maxidx = lci;
		}
		if (rci < sz_heap && arr[rci] > arr[maxidx]) {
			maxidx = rci;
		}
		// Implies the parent was not at the right position
		if (maxidx != pi) {
			swap(arr, maxidx, pi);
			heapify(arr, maxidx, sz_heap);
		}
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
