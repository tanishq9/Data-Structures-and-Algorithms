package Recursion;

public class CountStepsTo1 {
	public static void main(String[] args) {
		int n = 14;
		for (int i = 1; i <= 500; i++) {
			int[] dp = new int[i + 1];
			System.out.println(countStepto1(i, dp));
		}
	}

	private static int countStepto1(int n, int[] dp) {
		if (n == 1) {
			return 0;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		int contri1 = Integer.MAX_VALUE, contri2 = Integer.MAX_VALUE, contri3 = Integer.MAX_VALUE;
		if (n % 2 == 0) {
			contri1 = 1 + countStepto1(n / 2, dp);
		}
		// If hoga ,else if nahi
		if (n % 3 == 0) {
			contri2 = 1 + countStepto1(n / 3, dp);
		} else {
			contri3 = 1 + countStepto1(n - 1, dp);
		}
		dp[n] = Math.min(contri1, Math.min(contri2, contri3));
		return dp[n];
	}

}
