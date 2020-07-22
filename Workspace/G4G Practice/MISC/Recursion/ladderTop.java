package Recursion;

public class ladderTop {

	private static int possibleWays(int target, int maxJump, int[] dp) {
		if (target < 0) {
			return 0;
		}
		if (target == 0 || target == 1) {
			return 1;
		}
		if (dp[target] != -1) {
			return dp[target];
		}
		int ans = 0;
		for (int i = 1; i <= maxJump; i++) {
			dp[target - i] = possibleWays(target - i, maxJump, dp);
			ans += dp[target - i];
		}
		return ans;
	}

	private static int bottomUp(int target, int maxJump) {
		int[] dp = new int[target + 1];
		// Initial Seed
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= target; i++) {
			for (int j = 1; j <= maxJump; j++) {
				dp[i] += dp[i - j];
			}
		}
		return dp[target];
	}

	private static int bottomUpOptimized(int target, int maxJump) {
		int[] dp = new int[target + 1];
		// Initial Seed
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= target; i++) {
			dp[i] = 2 * dp[i - 1] - dp[i - (maxJump + 1)];
		}
		return dp[target];
	}

	public static void main(String[] args) {
		int target = 4;
		int maxJump = 2;
		int[] dp = new int[target + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		System.out.println(possibleWays(target, maxJump, dp));
		System.out.println(bottomUp(target, maxJump));
		System.out.println(bottomUpOptimized(target, maxJump));
	}
}
