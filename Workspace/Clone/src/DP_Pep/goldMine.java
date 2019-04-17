package DP_Pep;

public class goldMine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 4, 5, 7, 3, 5 }, { 6, 7, 2, 0, 2 }, { 3, 0, 5, 4, 6 }, { 2, 4, 3, 0, 3 }, { 5, 7, 6, 4, 2 } };
		System.out.println(goldMine(arr));
	}

	private static int goldMine(int[][] arr) {
		int[][] dp = new int[arr.length][arr[0].length];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (j == 0) {
					// Fist column as it is
					dp[i][j] = arr[i][j];
				} else if (i == 0) {
					// First row
					dp[i][j] = arr[i][j] + Math.max(dp[i + 1][j - 1], dp[i][j - 1]);
				} else if (i == dp.length - 1) {
					// Last row
					dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j - 1], dp[i][j - 1]);
				} else {
					// Generic case
					dp[i][j] = arr[i][j] + Math.max(Math.max(dp[i][j - 1], dp[i - 1][j - 1]), dp[i + 1][j - 1]);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + "\t");
				max = Math.max(max, dp[i][j]);
			}
			System.out.println();
		}
		return max;
	}

}
