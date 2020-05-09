package Misc;

public class matrixMultiplication {
	public static int[][] multiply(int[][] A, int[][] B) {
		int n = A.length;
		int p = B[0].length;
		int m = B.length;
		int[][] ab = new int[n][p];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < p; j++) {
				for (int k = 0; k < m; k++) {
					ab[i][j] = ab[i][j] + (A[i][k] * B[k][j]);
				}
			}
		}
		return ab;
	}
}
