package DP_Pep;

public class mazePath {

	public static void main(String[] args) {
		int m = 2, n = 9;
		System.out.println(countMazePath(m, n));
	}

	private static int countMazePath(int m, int n) {
		int[][] table = new int[m + 1][n + 1];
		for (int row = 0; row <= m; row++) {
			for (int col = 0; col <= n; col++) {
				// Region 1
				if (row == 0 && col == 0) {
					table[row][col] = 1;
				}
				// Region 2
				else if (row == 0) {
					table[row][col] = 1;
				}
				// Region 3
				else if (col == 0) {
					table[row][col] = 1;
				}
				// Region 4
				else {
					table[row][col] = table[row][col - 1] + table[row - 1][col];
				}
			}
		}
		return table[m][n];
	}

}
