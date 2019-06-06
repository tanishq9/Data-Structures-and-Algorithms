package Geeks_Recursion;

import java.util.Scanner;

public class Flood_Fill {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] matrix = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			int x = sc.nextInt();
			int y = sc.nextInt();
			int k = sc.nextInt();
			int prevc = matrix[x][y];
			fill(matrix, x, y, n, m, k, prevc);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					System.out.print(matrix[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	static void fill(int[][] matrix, int x, int y, int n, int m, int k, int prevc) {
		if (x < 0 || y < 0 || x >= n || y >= m) {
			return;
		}
		if (matrix[x][y] != prevc) {
			return;
		}
		matrix[x][y] = k; // fill color
		fill(matrix, x + 1, y, n, m, k, prevc);
		fill(matrix, x, y + 1, n, m, k, prevc);
		fill(matrix, x, y - 1, n, m, k, prevc);
		fill(matrix, x - 1, y, n, m, k, prevc);
	}

}
