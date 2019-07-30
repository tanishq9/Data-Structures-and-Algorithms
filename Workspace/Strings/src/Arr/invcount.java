package Arr;

import java.util.Scanner;

public class invcount {

	static long merge(int[] arr, int start, int end) {
		int s = start;
		int mid = (start + end) / 2;
		int e = mid + 1;
		int[] output = new int[end - start + 1];
		int k = 0;
		long inv = 0;
		while (s <= mid && e <= end) {
			if (arr[s] <= arr[e]) {
				output[k++] = arr[s++];
			} else {
				inv += (mid - s + 1);
				output[k++] = arr[e++];
			}
		}
		while (s <= mid) {
			output[k++] = arr[s++];
		}
		while (e <= end) {
			output[k++] = arr[e++];
		}
		for (int i = start, j = 0; i <= end && j < end - start + 1; i++, j++) {
			arr[i] = output[j];
		}
		return inv;
	}

	static long countInversions(int[] arr, int start, int end) {
		if (start >= end) {
			return 0;
		}
		int mid = (start + end) / 2;
		long inversions = countInversions(arr, start, mid) + countInversions(arr, mid + 1, end)
				+ merge(arr, start, end);
		return inversions;
	}

	// Complete the countInversions function below.
	static long countInversions(int[] arr) {
		return countInversions(arr, 0, arr.length - 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		long result = countInversions(arr);
		System.out.println(result);
	}
}
