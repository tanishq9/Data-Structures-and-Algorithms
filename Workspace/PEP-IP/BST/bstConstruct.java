package BST;

import java.util.Scanner;

public class bstConstruct {
	public static void BSTFormation(int[] arr, int i, int j) {
		if (i > j) {
			return;
		}
		int mid = i + (j - i) / 2;
		System.out.print(arr[mid] + " ");
		BSTFormation(arr, i, mid - 1);
		BSTFormation(arr, mid + 1, j);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		BSTFormation(arr, 0, arr.length - 1);
	}
}
