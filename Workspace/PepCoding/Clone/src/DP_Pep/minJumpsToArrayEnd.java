package DP_Pep;

public class minJumpsToArrayEnd {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 1, 2, 0, 1, 1 };
		int[] arr2 = { 2, 3, 1, 1, 2, 4, 2, 0, 1, 1 };
		int[] arr3 = { 32, 54, 12, 52, 56, 8, 30, 44, 94, 44, 39, 65, 19, 51, 91, 1, 5, 89, 34, 25, 58, 20, 51, 38, 65,
				30, 7, 20, 10, 51, 18, 43, 71, 97, 61, 26, 5, 57, 70, 65, 0, 75, 29, 86, 93, 87, 87, 64, 75, 88, 89,
				100, 7, 40, 37, 38, 36, 44, 24, 46, 95, 43, 89, 32, 5, 15, 58, 77, 72, 95, 8, 38, 69, 37, 24, 27, 90,
				77, 92, 31, 30, 80, 30, 37 };
		int[] arr4 = { 2, 1, 0, 3 };

		System.out.println(minJumpsBottomUpRightToLeft(arr4));
		// System.out.println(minJumpsBottomUpLeftToRight(arr2));
	}

	private static int minJumpsBottomUpRightToLeft(int[] arr) {
		// Meaning of cell : Minimum number of ways to reach arr[i] starting from
		// arr[n-1]
		// position
		int[] dp = new int[arr.length];
		dp[arr.length - 1] = 0;
		for (int i = arr.length - 2; i >= 0; i--) {
			int min = Integer.MAX_VALUE;
			for (int j = i + 1; j <= i + arr[i] && j < arr.length; j++) {
				// i+j is the possible position to go starting from i
				min = Math.min(min, dp[j]);
			}
			// Handle overflow
			if (min != Integer.MAX_VALUE) {
				dp[i] = min + 1;
			} else {
				dp[i] = min;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();
		return dp[0]; // It is the minimum number of ways to reach arr[0] from last position
	}

	private static int minJumpsBottomUpLeftToRight(int[] arr) {
		// Meaning of cell : number of ways to reach ith cell starting from jth position
		int[] dp = new int[arr.length];
		dp[0] = 0;
		for (int i = 1; i < arr.length; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				// In order to reach ith position , the jump should be sufficiently large enough
				if (j + arr[j] >= i) {
					dp[i] = Math.min(dp[j] + 1, dp[i]);
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();
		return dp[dp.length - 1];
	}

}
