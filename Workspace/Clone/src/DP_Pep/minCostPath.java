package DP_Pep;

public class minCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 31, 100, 65, 12, 18 }, { 10, 13, 47, 157, 6 }, { 100, 113, 174, 11, 33 },
				{ 88, 124, 41, 20, 140 }, { 99, 32, 111, 41, 20 } };
		System.out.println(cost(arr, arr.length));
	}

	private static int cost(int[][] arr, int n) {
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = arr[i][j];
				} else if (i == 0) {
					dp[i][j] = dp[i][j - 1] + arr[i][j];
				} else if (j == 0) {
					dp[i][j] = dp[i - 1][j] + arr[i][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[n - 1][n - 1];
	}
}
