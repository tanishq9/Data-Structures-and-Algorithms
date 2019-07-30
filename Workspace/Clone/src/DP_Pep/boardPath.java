package DP_Pep;

public class boardPath {

	public static void main(String[] args) {
		int source = 0, destination = 10;
		int[] dp = new int[destination + 1];
		System.out.println("Top Down : " + boardPathTopDown(source, destination, dp));
		System.out.println("Bottom Up : " + boardPathBottomUp(source, destination));
	}

	private static int boardPathTopDown(int source, int destination, int[] dp) {
		// Meaning of cell : Number of ways to reach destination from that cell
		// 0->10 is the biggest problem and in top down we start from bigger problem
		if (source > destination) {
			return 0;
		}
		if (source == destination) {
			return 1;
		}
		if (dp[source] != 0) {
			return dp[source];
		}
		int total = 0;
		for (int i = 1; i <= 6; i++) {
			total += boardPathTopDown(source + i, destination, dp);
		}
		return dp[source] = total;
	}

	private static int boardPathBottomUp(int source, int destination) {
		// Meaning of cell : Number of ways to reach destination from that cell
		// In Bottom Up , we start from the smallest problem and here the
		// smallest problem is reaching destination from destination i.e 1 way
		int[] dp = new int[destination + 1];
		dp[destination] = 1;
		for (int start = destination - 1; start >= source; start--) {
			for (int dice = 1; dice <= 6; dice++) {
				if ((start + dice) <= destination) {
					dp[start] += dp[start + dice];
				}
			}
		}

		for (int i = source; i < dp.length; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();

		return dp[source]; // number of ways to reach destination from source
	}

}
