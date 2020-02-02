package DP_Pep;

public class submatrixof1s {

	public static void main(String[] args) {
		int[][] arr = { { 1, 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1, 0 } };
		System.out.println(max(arr));
	}

	public static int max(int[][] arr) {
		int[][] strg = new int[arr.length][arr.length];
		int largest = 0;
		// Meaning of strg_[i][j] : If we consider this cell as top left then what is
		// maximum size of sub-matrix formed
		for (int i = strg.length - 1; i >= 0; i--) {
			for (int j = strg.length - 1; j >= 0; j--) {
				// Last row
				if (i == strg.length - 1) {
					strg[i][j] = arr[i][j];
				}
				// Last column
				else if (j == strg.length - 1) {
					strg[i][j] = arr[i][j];
				} else if (arr[i][j] == 0) {
					strg[i][j] = 0;
				}
				// else
				else {
					strg[i][j] = Math.min(Math.min(strg[i][j + 1], strg[i + 1][j]), strg[i + 1][j + 1]) + 1;
				}
				largest = Math.max(largest, strg[i][j]);
			}
		}
		return largest;
	}

}
