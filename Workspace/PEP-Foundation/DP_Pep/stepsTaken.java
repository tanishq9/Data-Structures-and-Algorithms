package DP_Pep;

public class stepsTaken {

	public static void main(String[] args) {
		int steps = 6;
		int k = 3; // max jump
		System.out.println(stepsTaken(steps, k));
		System.out.println(stepsTakenBottomUp(steps, k));
	}

	private static int stepsTaken(int steps, int k) {
		if (steps == 0) {
			return 1;
		}
		int total = 0;
		for (int i = 1; i <= k; i++) {
			if ((steps - i) >= 0) {
				total += stepsTaken(steps - i, k);
			}
		}
		return total;
	}

	private static int stepsTakenBottomUp(int steps, int maxJump) {
		// MEANING OF CELL : dp[i] denotes the number of ways to reach that cell from source i.e 0

		int[] dp = new int[steps + 1]; // dp.length = destination step + 1
		dp[0] = 1;
		
		for (int step = 1; step <= steps; step++) {
			for (int jump = 1; jump <= maxJump; jump++) {
				if ((step - jump) >= 0) {
					dp[step] += dp[step - jump];
				}
			}
		}

		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();
		
		return dp[steps];
	}

}
