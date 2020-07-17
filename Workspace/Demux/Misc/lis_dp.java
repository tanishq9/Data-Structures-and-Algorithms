package Recursion_Pep_Online;

import java.util.Arrays;

public class lis_dp {
	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 50, 1 };
		int n = arr.length - 1;
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);
		lis(arr, n, dp, new String[arr.length]);
		System.out.println(omax);
		System.out.println(opath);
	}

	static int omax = 1;
	static String opath = "";

	static int lis(int[] arr, int n, int[] cache, String[] path) {
		if (cache[n] != 1) {
			return cache[n];
		}
		int max = 1;
		String currentPath = "";
		for (int i = n - 1; i >= 0; i--) {
			int maxLen = lis(arr, i, cache, path);
			if (arr[n] > arr[i] && max < maxLen + 1) {
				// +1 for that nth item which will lead this maxLen sequence
				max = maxLen + 1;
				currentPath = path[i];
			}
		}
		// update values for best sequence till length n
		// in terms of length and string path
		if (currentPath.length() == 0) {
			path[n] = arr[n] + "";
		} else {
			path[n] = currentPath + " " + arr[n];
		}
		cache[n] = max;
		// System.out.println(arr[n] + ". " + path[n] + " " + cache[n]);
		// update maximum length and path
		if (max > omax) {
			omax = cache[n];
			opath = path[n];
		}
		return cache[n];
	}
}
