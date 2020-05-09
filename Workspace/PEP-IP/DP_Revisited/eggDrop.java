package DP_Revisited;

public class eggDrop {
	public static void main(String[] args) {
		int f = 10, e = 2;
		System.out.println(eggDrop(f, e));
	}

	static int eggDrop(int floor, int eggs) {
		int[][] dp = new int[eggs + 1][floor + 1];
		// eggs = 0 is no case , we start from eggs = 1
		// dp[i][j] is the minimum number of trials to find the critical floor given
		// we can drop i eggs from j floors
		for (int e = 1; e < dp.length; e++) {
			for (int f = 0; f < dp[0].length; f++) {
				if (f == 0) {
					dp[e][f] = 0;
				} else if (e == 1) {
					dp[e][f] = f;
				} else {
					// plan according to the worst day
					// find the minimum of all the maximums
					// min(max([e-1,k-1],[e,f-k]),...similiar other maxes)
					dp[e][f] = Integer.MAX_VALUE;
					for (int k = 1; k <= f; k++) {
						int survives = dp[e - 1][k - 1];
						int breaks = dp[e][f - k];
						int max = Math.max(survives, breaks);
						dp[e][f] = Math.min(dp[e][f], max);
					}
					dp[e][f] += 1;// +1 for our own attempt
				}
			}
		}
		for (int i = 0; i <= eggs; i++) {
			for (int j = 0; j <= floor; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[eggs][floor];
	}
}
