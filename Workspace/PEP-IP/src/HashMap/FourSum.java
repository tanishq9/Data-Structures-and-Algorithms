package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FourSum {
	public static List<List<Integer>> fourSum(int[] arr, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(arr);
		int n = arr.length;
		for (int i = 0; i <= (n - 4); i++) {
			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			for (int j = i + 1; j <= (n - 3); j++) {
				if (j > (i + 1) && arr[j] == arr[j - 1]) {
					continue;
				}
				int start = j + 1;
				int end = n - 1;
				int remsum = target - arr[i] - arr[j];
				while (start < end) {
					if (arr[start] + arr[end] == remsum) {
						result.add(Arrays.asList(arr[i], arr[j], arr[start], arr[end]));
						while (start < end && arr[start] == arr[start + 1]) {
							start++;
						}
						while (start < end && arr[end] == arr[end - 1]) {
							end--;
						}
						start++;
						end--;
					} else if (arr[start] + arr[end] < remsum) {
						while (start < end && arr[start] == arr[start + 1]) {
							start++;
						}
						start++;
					} else {
						while (start < end && arr[end] == arr[end - 1]) {
							end--;
						}
						end--;
					}
				}
			}
		}
		return result;
	}

	// -----------------------------------------------------
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int target = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		List<List<Integer>> ans = fourSum(arr, target);

		for (List<Integer> a : ans) {
			for (int element : a) {
				System.out.print(element + " ");
			}
			System.out.println();
		}

	}

}