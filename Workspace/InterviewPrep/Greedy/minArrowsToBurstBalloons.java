package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class minArrowsToBurstBalloons {
	public int findMinArrowShots(int[][] points) {
		if (points.length == 0) {
			return 0;
		}
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] f, int[] s) {
				return f[1] - s[1];
			}
		});
		int count = 1;
		int maxEnd = points[0][1];
		for (int i = 0; i < points.length; i++) {
			if (points[i][0] <= maxEnd) {
				continue;
			}
			maxEnd = points[i][1];
			count++;
		}
		return count;
	}
}
