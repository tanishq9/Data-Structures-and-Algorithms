package DP_Pep;

import java.util.Scanner;

public class sparseTable {

	private static int getFloor(int n) {
		int log = 0;
		while ((1 << log) <= n) {
			log++;
		}
		return log - 1;
	}

	private static void preprocess(int[] arr, int[][] sparse) {
		for (int i = 0; i < sparse.length; i++) {
			sparse[i][0] = arr[i];
		}
		// sparse[i][j] stores the value for range : [i,2^j-1]
		for (int j = 1; j < sparse[0].length; j++) {
			// Not all values of sparse table will be filled as we keep on
			// increasing the range in every cell , therefore every time
			// we iterate over only some specific cells
			for (int i = 0; i <= sparse.length - (1 << j); i++) {
				int f1 = sparse[i][j - 1];
				int f2 = sparse[i + (1 << (j - 1))][j - 1];
				sparse[i][j] = Math.min(f1, f2);
			}
		}
	}

	private static int query(int[][] sparse, int l, int r) {
		int c = r - l + 1;
		int column = getFloor(c);
		int f1 = sparse[l][column];
		int f2 = sparse[r - (1 << column) + 1][column];
		return Math.min(f1, f2);
	}

	private static void print(int[][] sparse) {
		for (int i = 0; i < sparse.length; i++) {
			for (int j = 0; j < sparse[0].length; j++) {
				System.out.print(sparse[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t != 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int[][] sparse = new int[arr.length][getFloor(arr.length) + 1];
			preprocess(arr, sparse);
			// print(sparse);
			int q = sc.nextInt();
			while (q != 0) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				System.out.println(query(sparse, l - 1, r - 1));
				q--;
			}
			t--;
		}
	}
}