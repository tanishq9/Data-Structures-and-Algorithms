package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class minPlatforms {
	public static int min(int[] arrival, int[] dept) {
		Arrays.sort(arrival);
		Arrays.sort(dept);
		int in = 0;
		int max = 0;
		int start = 0;
		int end = 0;
		while (start < arrival.length) {
			if (arrival[start] < dept[end]) {
				in++;
				start++;
			} else if (arrival[start] >= dept[end]) {
				in--;
				end++;
			}
			max = Math.max(max, in);
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int[] dept = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				dept[i] = sc.nextInt();
			}
			System.out.println(min(arr, dept));
		}
	}
}
