package Sorting;

import java.util.Arrays;

public class counting_Radix_Sort {

	static int[] countSort(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int[] fm = new int[max + 1];
		// building frequency array
		for (int i = 0; i < arr.length; i++) {
			fm[arr[i]]++;
		}
		// building prefix frequency array
		for (int i = 1; i <= max; i++) {
			fm[i] += fm[i - 1];
		}
		int[] out = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			int index = fm[arr[i]] - 1;
			out[index] = arr[i];
			fm[arr[i]]--;
		}
		return out;
	}

	static int[] countForRadix(int[] arr, int d) {
		int[] fm = new int[10];
		// building frequency array
		for (int i = 0; i < arr.length; i++) {
			fm[arr[i] / d % 10]++;
		}
		// building prefix frequency array
		for (int i = 1; i <= 9; i++) {
			fm[i] += fm[i - 1];
		}
		int[] out = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			int index = fm[arr[i] / d % 10] - 1;
			out[index] = arr[i];
			fm[arr[i] / d % 10]--;
		}
		return out;
	}

	static void radixSort(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int d = 1;
		while (max / d > 0) {
			arr = countForRadix(arr, d);
			d *= 10;
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] arr = { 4, 1, 2, 7, 4, 9, 1, 8, 0, 2, 1, 5, 0, 8 };
		for (int element : countSort(arr)) {
			System.out.print(element + " ");
		}
		System.out.println();
		int[] ar = { 576, 282, 77, 34, 981, 62, 11, 348, 7, 412, 69, 438, 992, 324, 287, 76 };
		radixSort(ar);
	}
}
