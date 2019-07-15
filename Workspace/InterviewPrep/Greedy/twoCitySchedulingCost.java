package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class twoCitySchedulingCost {
	public int twoCitySchedCost(int[][] costs) {
		// Sort by savings
		Arrays.sort(costs, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				int savingA = a[0] - a[1];
				int savingB = b[0] - b[1];
				return savingA - savingB;
			}
		});
		int costA = 0, costB = 0;
		for (int i = 0; i < costs.length / 2; i++) {
			costA += costs[i][0];
		}
		for (int i = costs.length / 2; i < costs.length; i++) {
			costB += costs[i][1];
		}
		return costA + costB;
	}
}
