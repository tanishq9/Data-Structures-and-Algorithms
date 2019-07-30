package DP_Pep;

import java.util.Arrays;

public class bitonic {

	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
		System.out.println(bitonic(arr));
	}

	private static int bitonic(int[] arr) {
		int[] lis = new int[arr.length];
		Arrays.fill(lis, 1);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
		}
		int[] lds = new int[arr.length];
		Arrays.fill(lds, 1);
		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					lds[i] = Math.max(lds[i], lds[j] + 1);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, lis[i] + lds[i] - 1);
		}
		return max;
	}

}
