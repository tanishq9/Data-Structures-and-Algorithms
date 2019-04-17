package DP;

public class matrixChainMultiplication {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 60 };
		System.out.println(mcm(arr));
	}

	private static int mcm(int[] arr) {
		int[][] table = new int[arr.length - 1][arr.length - 1];
		// Outer loop is for gap size
		for (int gap = 1; gap < table.length; gap++) {
			for (int i = 0, j = gap; j < table[0].length; i++, j++) {
				if (gap == 1) {
					table[i][j] = arr[i] * arr[i + 1] * arr[i + 2];
				} else {
					table[i][j] = Integer.MAX_VALUE;
					for (int k = 1; k <= gap; k++) {
						int lp = table[i][i + k - 1];
						int rp = table[i + k][j];
						int matm = arr[i] * arr[j + 1] * arr[i + k];
						table[i][j] = Math.min(table[i][j], lp + rp + matm);
					}
				}
			}
		}
		return table[0][table.length - 1];
	}

}
