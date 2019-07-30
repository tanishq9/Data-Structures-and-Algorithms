package DP;

import java.util.Scanner;

public class mobileNumericKeypad {

	private static final int[][] neighbours = { { 8 }, // 0
			{ 2, 4 }, // 1
			{ 1, 5, 3 }, // 2
			{ 2, 6 }, // 3
			{ 1, 5, 7 }, // 4
			{ 2, 4, 6, 8 }, // 5
			{ 3, 5, 9 }, // 6
			{ 4, 8 }, // 7
			{ 0, 5, 7, 9 }, // 8
			{ 6, 8 } // 9
	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// dp[i][j] : number of ways in which we can form i length digits
		// eg : dp[1][2] is number of digits of length 1 using 2nd digit
		// ans is summation of digits ending on all 0-9 for given length
		while (t-- > 0) {
			int n = sc.nextInt();
			long[][] dp = new long[n + 1][10];
			// first row is trivial
			// only 1 length character possible for row=1 (digits ending with length 1)
			for (int d = 0; d <= 9; d++) {
				dp[1][d] = 1;
			}
			for (int i = 2; i <= n; i++) {
				for (int d = 0; d <= 9; d++) {
					for (int k = 0; k < neighbours[d].length; k++) {
						dp[i][d] += dp[i - 1][neighbours[d][k]];
					}
				}
			}
			long sum = 0;
			for (int i = 0; i <= 9; i++) {
				sum += dp[n][i];
			}
			System.out.println(sum);
		}

	}
}
