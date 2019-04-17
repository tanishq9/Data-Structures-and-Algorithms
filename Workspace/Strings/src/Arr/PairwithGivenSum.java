package Arr;

import java.util.Arrays;
import java.util.HashMap;

public class PairwithGivenSum {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 9, 8, 3, 4 };
		// 0(nlogn) approach
		Arrays.sort(arr);
		int l = 0, r = arr.length - 1, k = 14;
		Boolean isFound = false;
		while (l < r) {
			if (arr[l] + arr[r] == k) {
				isFound = true;
				break;
			}
			if ((arr[l] + arr[r]) < k) {
				l++;
			}
			if ((arr[l] + arr[r]) > k) {
				r--;
			}
		}
		if (isFound == true) {
			System.out.println("Found");
		} else {
			System.out.println("Not Found");
		}

		// 0(n) approach
		Boolean flag = false;
		HashMap<Integer, Integer> hmap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int temp = k - arr[i];
			if (temp >= 0 && hmap.containsKey(temp)) {
				flag = true;
			}
			hmap.put(arr[i], 1);
		}
		if (flag == true) {
			System.out.println("FOUND");
		} else {
			System.out.println("NOT FOUND");
		}

	}

}
