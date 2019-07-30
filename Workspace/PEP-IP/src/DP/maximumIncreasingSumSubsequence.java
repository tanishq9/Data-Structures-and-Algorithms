package DP;

import java.util.Scanner;

public class maximumIncreasingSumSubsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(maxSumIncSubseq(arr));
		}
	}

	static int maxSumIncSubseq(int[] arr) {
		int[] msi = new int[arr.length];
		int omax = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			msi[i] = arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			int maxtillnow = Integer.MIN_VALUE;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					// agar increasing hai toh uske saath
					// jaake lag jao jo maximum sum deta hai
					maxtillnow = Math.max(msi[j], maxtillnow);
				}
			}
			if (maxtillnow != Integer.MIN_VALUE) {
				msi[i] += maxtillnow;
			}
			omax = Math.max(omax, msi[i]);
		}
		return omax;
	}

}
