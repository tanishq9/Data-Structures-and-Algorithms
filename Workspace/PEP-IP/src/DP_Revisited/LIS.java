package DP_Revisited;

import java.util.Arrays;

public class LIS {

	static void lis(int[] arr) {
		int[] lis = new int[arr.length];
		lis[0] = 1;
		// Also printing the LIS
		String[] plis = new String[arr.length];
		plis[0] = arr[0] + " ";
		int omax = 0;
		String opath = "";
		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					if (lis[i] < lis[j]) {
						lis[i] = lis[j];
						plis[i] = plis[j];
					}
				}
			}
			lis[i] += 1;
			plis[i] = plis[i] + " " + arr[i];
			if (omax < lis[i]) {
				omax = lis[i];
				opath = plis[i];
			}
		}
		System.out.println(Arrays.toString(lis));
		System.out.println(omax);
		System.out.println(opath);
	}

	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
		lis(arr);
	}
}
