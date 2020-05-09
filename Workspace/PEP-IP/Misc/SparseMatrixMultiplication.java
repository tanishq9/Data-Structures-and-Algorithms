package Misc;

public class SparseMatrixMultiplication {
	public static int[][] multiply(int[][] A, int[][] B) {
		int n = A.length; // rows in A
		int m = B[0].length; // columns in B
		int c = A[0].length; // common dimension
		int[][] ab = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < c; j++) {
				if (A[i][j] != 0) {
					for (int k = 0; k < m; k++) {
						ab[i][k] += A[i][j] * B[j][k];
					}
				}
			}
		}

		return ab;
	}

}
