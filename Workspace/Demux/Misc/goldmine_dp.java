package Recursion_Pep_Online;

import java.util.Scanner;

public class goldmine_dp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] grid = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			int[][] dp = new int[n][m];
			int max = 0, maxr = -1, maxc = -1;
			for (int j = 0; j < m; j++) {
				for (int i = 0; i < n; i++) {
					if (j == 0) {
						dp[i][0] = grid[i][0];
					} else {
						int c1 = (i - 1) >= 0 ? dp[i - 1][j - 1] : 0;
						int c2 = dp[i][j - 1];
						int c3 = (i + 1) < n ? dp[i + 1][j - 1] : 0;
						dp[i][j] = grid[i][j] + Math.max(c1, Math.max(c2, c3));
					}
					if (j == m - 1) {
						if (dp[i][m - 1] >= max) {
							max = dp[i][m - 1];
							maxr = i;
							maxc = m - 1;
						}
						max = Math.max(max, dp[i][m - 1]);
					}
				}
			}
			System.out.println(max + " " + maxr + " " + maxc);
			// reverse engineer the solution
			printPath(dp, maxr, maxc);
		}
	}

	static void printPath(int[][] dp, int x, int y) {

		if (y == 0) {
			System.out.println(x + "," + y + " <- Start");
			return;
		}

		System.out.print(x + "," + y + " <- ");

		int max = 0, maxr = x, maxc = y - 1;
		if (dp[x][maxc] >= max) {
			max = dp[x][maxc];
			maxr = x;
		}
		if (x - 1 >= 0 && dp[x - 1][maxc] >= max) {
			max = dp[x - 1][maxc];
			maxr = x - 1;
		}
		if (x + 1 < dp.length && dp[x + 1][maxc] >= max) {
			max = dp[x + 1][maxc];
			maxr = x + 1;
		}

		printPath(dp, maxr, maxc);

	}

}
