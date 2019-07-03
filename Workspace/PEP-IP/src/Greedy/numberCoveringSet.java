package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class numberCoveringSet {
	public static int findMinArrowShots(int[][] points) {
		// [0, 4], [1, 2], [5, 7], [6, 7], [6, 9], [8, 10] -> TestCase
		if (points.length == 0) {
			return 0;
		}
		// Sort on the basis of end time
		// We want to cover all points using minimum number of points
		// so we look for first end point or first closing range and
		// see how many interval can fall in this range
		// [ [0 [1 2] 4] [5 [[6 7]] [8 9] 10]]
		// 2 7 10 will be the output
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] f, int[] s) {
				return f[1] - s[1];
			}
		});
		int count = 1;
		int maxEnd = points[0][1];
		System.out.println(maxEnd);
		for (int i = 1; i < points.length; i++) {
			if (points[i][0] <= maxEnd) {
				continue;
			}
			maxEnd = points[i][1];
			System.out.println(maxEnd);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] points = { { 0, 4 }, { 1, 2 }, { 5, 7 }, { 6, 7 }, { 6, 9 }, { 8, 10 } };
		System.out.println(findMinArrowShots(points));
	}
}
