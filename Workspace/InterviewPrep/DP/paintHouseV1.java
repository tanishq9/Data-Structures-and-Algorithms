package DP;

public class paintHouseV1 {
	public static int minCost(int[][] costs) {
		// Write your code here
		for (int i = 1; i < costs.length; i++) {
			costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
			costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
			costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
		}
		int n = costs.length - 1;
		return Math.min(costs[n][0], Math.min(costs[n][1], costs[n][2]));
	}
}
