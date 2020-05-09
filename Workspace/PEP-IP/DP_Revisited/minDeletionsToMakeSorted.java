package DP_Revisited;

import java.util.Arrays;
import java.util.Scanner;

public class minDeletionsToMakeSorted {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scn.nextInt();
		mindeletions(a, n);
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array and its length
	// It should print the required output

	public static void mindeletions(int[] a, int n) {
		// Write your code here
		int[] lis = new int[n];
		int omax = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (a[i] > a[j]) {
					lis[i] = Math.max(lis[i], lis[j]);
				}
			}
			lis[i] += 1;
			omax = Math.max(omax, lis[i]);
		}
		System.out.println(Arrays.toString(lis));
		System.out.println(n - omax);
	}
}
