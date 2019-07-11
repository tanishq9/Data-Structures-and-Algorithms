package DP;

public class minimumSum2Partition {
	static int findMinSumPartition(int arr[], int n) {
		// Write your code here
		int target = 0;
		for (int i = 0; i < arr.length; i++) {
			target += arr[i];
		}
		int[][] dp = new int[arr.length + 1][target + 1];
		// storage[i][j] : If it is possible to reach j target using i players
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				// no players 0 target
				if (i == 0 && j == 0) {
					dp[i][j] = 1;
				}
				// players but 0 target
				if (j == 0 && i >= 1) {
					dp[i][j] = 1;
				}
				// no players and >0 target
				if (i == 0 && j >= 1) {
					dp[i][j] = 0;
				}
				// if we got more than 1 player
				if (i >= 1) {
					if (dp[i - 1][j] == 1) {
						dp[i][j] = 1;
					} else if (j - arr[i - 1] >= 0 && dp[i - 1][j - arr[i - 1]] == 1) {
						dp[i][j] = 1;
					}
				}
			}
		}
		int p1 = 0;
		for (int j = target / 2; j >= 0; j--) {
			if (dp[arr.length][j] == 1) {
				p1 = j;
				break;
			}
		}
		int p2 = target - p1;
		// System.out.println(p1+" "+p2);
		return p2 - p1;
	}
}
