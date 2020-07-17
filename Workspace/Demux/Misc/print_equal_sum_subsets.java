package Recursion_Pep_Online;

import java.util.Arrays;

public class print_equal_sum_subsets {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		Arrays.sort(arr);
		getSubsets(arr, 0, 0, 0, "", "");
	}

	static void getSubsets(int[] arr, int index, int set1Sum, int set2Sum, String set1, String set2) {

		if (index == arr.length) {
			if (set1Sum == set2Sum) {
				System.out.println(set1Sum + " " + set1 + " | " + set2);
			}
			return;
		}

		getSubsets(arr, index + 1, set1Sum + arr[index], set2Sum, set1 + " " + arr[index], set2);

		getSubsets(arr, index + 1, set1Sum, set2Sum + arr[index], set1, set2 + " " + arr[index]);

	}
}
