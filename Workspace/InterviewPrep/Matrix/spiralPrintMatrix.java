package Matrix;

import java.util.Scanner;

public class spiralPrintMatrix {

	static void spirallyPrint(int[][] matrix) {
		int count = matrix.length * matrix[0].length;
		int top = 0, left = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;
		while (count != 0) {
			// count>0 is checked because otherwise we will print extra in m!=n matrices
			if (count > 0) {
				for (int col = left; col <= right; col++) {
					System.out.print(matrix[top][col] + " ");
					count--;
				}
				top++;
			}
			if (count > 0) {
				for (int row = top; row <= bottom; row++) {
					System.out.print(matrix[row][right] + " ");
					count--;
				}
				right--;
			}
			if (count > 0) {
				for (int col = right; col >= left; col--) {
					System.out.print(matrix[bottom][col] + " ");
					count--;
				}
				bottom--;
			}
			if (count > 0) {
				for (int row = bottom; row >= top; row--) {
					System.out.print(matrix[row][left] + " ");
					count--;
				}
				left++;
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// 2
		// 4 4
		// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
		// 3 4
		// 1 2 3 4 5 6 7 8 9 10 11 12
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
			spirallyPrint(matrix);
		}
	}
}
