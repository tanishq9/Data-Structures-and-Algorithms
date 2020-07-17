package Recursion_Pep_Online;

public class egg_drop {
	public static void main(String[] args) {
		int eggs = 2;
		int floors = 64;
		int[][] dp = new int[eggs + 1][floors + 1];
		System.out.println(min_trial(eggs, floors, dp));
	}

	static int min_trial(int eggs, int floors, int[][] dp) {
		if (eggs == 1) {
			return floors;
		}
		if (floors == 0) {
			return 0;
		}
		if (floors == 1) {
			return 1;
		}
		if (dp[eggs][floors] != 0) {
			return dp[eggs][floors];
		}

		int min = Integer.MAX_VALUE;
		// we are throwing egg from kth floor
		// if it breaks then we will check for other k-1 bottom floors
		// if it survives then we will check for f-k floors above it
		for (int k = 1; k <= floors; k++) {
			int eggBreaks = min_trial(eggs - 1, k - 1, dp);
			int eggSurvives = min_trial(eggs, floors - k, dp);
			// best of the worst -> guaranteed plan
			min = Math.min(min, Math.max(eggBreaks, eggSurvives));
		}
		return dp[eggs][floors] = min + 1;
	}

}
