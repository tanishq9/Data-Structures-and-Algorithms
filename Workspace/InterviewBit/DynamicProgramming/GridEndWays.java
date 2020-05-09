package DynamicProgramming;

public class GridEndWays {

	public static void main(String[] args) {
		int m = 3, n = 4;
		char[][] arr = { { '.', '.', 'X', '.' }, { '.', '.', '.', '.' }, { '.', 'X', '.', '.' } };
		System.out.println(minCost(arr, m, n));
	}

	static int MOD = 100;

	private static int minCost(char[][] arr, int m, int n) {

		int[][] dp = new int[m][n];

		if (arr[0][0] == 'X') {
			return -1;
		}

		// For the first row
		for (int i = 0; i < m; i++) {
			if (arr[0][i] == 'X') {
				break;
			}
			// There is only one way to reach cell i.e from the left
			dp[0][i] = 1;
		}

		// For the first column
		for (int i = 0; i < n; i++) {
			if (arr[i][0] == 'X') {
				return -1;
			}
			// There is only one way to reach cell i.e from the top
			dp[i][0] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (dp[i][j] == 'X') {
					continue;
				}
				if (dp[i][j] != 'X') {
					dp[i][j] = dp[i - 1][j] % MOD;
				}
				if (dp[i][j] != 'X') {
					dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
				}
			}
		}

		if (dp[m - 1][n - 1] == 'X') {
			return -1;
		} else {
			return dp[m - 1][n - 1];
		}
		
	}
}