package Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class findAllPairWithGivenSum {
	public static void print(int[] arr1, int[] arr2, int k) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int s = 0;
		int e = arr2.length - 1;
		boolean start = false;
		while (s < arr1.length && e >= 0) {
			if (arr1[s] + arr2[e] == k) {
				if (start == false) {
					System.out.print(arr1[s] + " " + arr1[e]);
					start = true;
				} else {
					System.out.print("," + arr1[s] + " " + arr1[e]);
				}
				s++;
				e--;
			} else if (arr1[s] + arr2[e] < k) {
				s++;
			} else {
				e--;
			}
		}

	}

	public static ArrayList<Integer> twoSum(ArrayList<Integer> nums, int target) {
		int s = 0;
		int e = nums.size() - 1;
		while (s < e) {
			int curr = nums.get(s) + nums.get(e);
			if (curr == target) {
				break;
			} else if (curr < target) {
				s++;
			} else {
				e--;
			}
		}
		return new ArrayList<Integer>(Arrays.asList(s, e));
	}

	// Don't make changes here
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int k = scn.nextInt();
		int[] num = new int[n];
		int[] num2 = new int[m];
		for (int i = 0; i < n; i++) {
			num[i] = scn.nextInt();
		}

		for (int i = 0; i < m; i++) {
			num2[i] = scn.nextInt();
		}
		print(num, num2, k);
		System.out.println();

	}

}
