package DP;

public class optimalGameStrategy {
	public static void main(String[] args) {
		int[] arr = { 8, 15, 3, 7 };
		int[][] dp = new int[arr.length][arr.length];
		for (int gap = 0; gap < arr.length; gap++) {
			for (int i = 0, j = i + gap; j < arr.length; i++, j++) {
				if (gap == 0) {
					dp[i][j] = arr[i];
				} else if (gap == 1) {
					dp[i][j] = Math.max(arr[i], arr[j]);
				} else if (gap == 2) {
					int max = Integer.MIN_VALUE;
					int min = Integer.MAX_VALUE;
					for (int s = i; s <= j; s++) {
						max = Math.max(max, arr[s]);
						min = Math.min(min, arr[s]);
					}
					dp[i][j] = max + min;
				} else {
					int f1 = arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
					int f2 = arr[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]);
					dp[i][j] = Math.max(f1, f2);
				}
			}
		}
		System.out.println(dp[0][arr.length - 1]);
	}
}
