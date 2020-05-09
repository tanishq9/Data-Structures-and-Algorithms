package DP;

public class goldMine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 4, 5, 7, 3, 5 }, { 6, 7, 2, 0, 2 }, { 3, 0, 5, 4, 6 }, { 2, 4, 3, 0, 3 }, { 5, 7, 6, 4, 2 } };
		int[][] storage = maxPath(arr);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, storage[i][arr.length - 1]);
		}
		for (int i = 0; i < arr.length; i++) {
			if (storage[i][0] == max) {

			}
		}
	}

	private static int[][] maxPath(int[][] arr) {
		int[][] dp = new int[arr.length][arr[0].length];

		// First column
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = arr[i][0];
		}

		for (int j = 1; j < arr.length; j++) {
			for (int i = 0; i < arr.length; i++) {
				if (i == 0) {
					dp[0][j] = Math.max(dp[i + 1][j - 1], dp[i][j - 1]) + arr[i][j];
				} else if (i == arr.length - 1) {
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i][j - 1]) + arr[i][j];
				} else {
					dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1], dp[i - 1][j - 1]), dp[i][j - 1]) + arr[i][j];
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(dp[i][j] + "\t");
			}
			System.out.println();
		}
		return dp;
	}

	private static void printPath(int[][] storage, int i, int j, String path) {
		// reached first column from last
		if (j == 0) {

		}
		// First row
		else if (i == 0) {

		}
		// Last row
		else if (i == storage.length - 1) {

		}
		// Otherwise
		else {

		}
	}

}
