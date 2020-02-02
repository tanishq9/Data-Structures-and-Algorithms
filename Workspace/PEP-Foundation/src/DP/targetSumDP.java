package DP;

public class targetSumDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 5, 6, 1 };
		int targetSum = 7;
		System.out.println(isSumPossible(arr, targetSum));
	}

	private static boolean isSumPossible(int[] arr, int targetSum) {
		// Sum along the column and elements along the row
		int[][] dp = new int[arr.length + 1][targetSum + 1];
		dp[0][0] = 1;
		// Filling the first row
		for (int j = 1; j < dp[0].length; j++) {
			dp[0][j] = 0;
		}
		// Filling the first column
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		// Otherwise
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				// 'j' represent the target sum
				dp[i][j] = 0; // initially let storage[i][j]=0 (by default it is also 0)
				if ((j - arr[i - 1]) >= 0 && dp[i - 1][j - arr[i - 1]] == 1) {
					dp[i][j] = 1;
				} else if (dp[i - 1][j] == 1) {
					dp[i][j] = 1;
				}
			}
		}
		// Printing the storage matrix
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + "\t");
			}
			System.out.println();
		}

		// Function to print the subsets
		printSubset(dp, arr, arr.length, targetSum, "");

		return dp[arr.length][targetSum] == 1;
	}

	private static void printSubset(int[][] dp, int[] arr, int i, int j, String str) {
		if (i == 0 && j == 0) {
			System.out.println(str);
			return;
		} else if (i == 0) {
			return;
		} else if (j == 0) {
			if (dp[i - 1][j] == 1) {
				printSubset(dp, arr, i - 1, j, str);
			}
			if (j >= arr[i - 1] && dp[i - 1][j - arr[i - 1]] == 1) {
				printSubset(dp, arr, i - 1, j - arr[i - 1], str + " " + arr[i - 1]);
			}
		} else {
			if (dp[i - 1][j] == 1) {
				printSubset(dp, arr, i - 1, j, str);
			}
			if (j >= arr[i - 1] && dp[i - 1][j - arr[i - 1]] == 1) {
				printSubset(dp, arr, i - 1, j - arr[i - 1], str + " " + arr[i - 1]);
			}
		}
	}

}
