package DP;

public class mazePath {

	public static void main(String[] args) {
		System.out.println(mazePath(3, 3));
		System.out.println(mazePath2(2, 2));
	}

	private static int mazePath(int r, int c) {
		int[][] table = new int[r + 1][c + 1];
		for (int i = 0; i <= r; i++) {
			for (int j = 0; j <= c; j++) {
				if (i == 0 && j >= 1) {
					table[0][j] = 1;
				} else if (j == 0 && i >= 1) {
					table[i][0] = 1;
				} else if (i >= 1 && j >= 1) {
					table[i][j] = table[i][j - 1] + table[i - 1][j];
				}
			}
		}
		return table[r][c];
	}

	private static int mazePath2(int r, int c) {
		int[][] table = new int[r + 1][c + 1];
		table[0][0] = 1;
		for (int i = 0; i <= r; i++) {
			for (int j = 0; j <= c; j++) {
				// First row
				if (i == 0 && j >= 1) {
					table[0][j] = table[i][j - 1] + 1;
				} // First column
				else if (j == 0 && i >= 1) {
					table[i][0] = table[i][j] + 1;
				} else if (i >= 1 && j >= 1) {
					table[i][j] = table[i][j - 1] + table[i - 1][j] + table[i - 1][j - 1];
				}
			}
		}
		return table[r][c];
	}

}
