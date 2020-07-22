package DynamicProgramming;

public class minCostPath {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(minCost(arr));
	}

	private static int minCost(int[][] arr) {

		int[][] dp = new int[arr.length][arr.length]; // considering square matrix
		dp[0][0] = arr[0][0];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i == 0 && j >= 1) {
					dp[0][j] = arr[0][j] + dp[0][j - 1];
					continue;
				} else if (j == 0 && i >= 1) {
					dp[i][0] = arr[i][0] + dp[i - 1][0];
					continue;
				} else if (i >= 1 && j >= 1) {
					dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[arr.length - 1][arr.length - 1];
	}

}
