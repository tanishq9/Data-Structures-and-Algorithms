package Greedy;

import java.util.Arrays;

public class meetingRooms {
	public static int minMeetingRooms(int[][] intervals) {
		int[] arrival = new int[intervals.length];
		int[] dept = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			arrival[i] = intervals[i][0];
			dept[i] = intervals[i][1];
		}
		Arrays.sort(arrival);
		Arrays.sort(dept);
		int start = 0;
		int end = 0;
		int platforms = 0;
		int in = 0;
		while (start < arrival.length && end < dept.length) {
			if (arrival[start] < dept[end]) {
				in++;
				start++;
				platforms = Math.max(platforms, in);
			} else if (arrival[start] >= dept[end]) {
				in--;
				end++;
			}
		}
		return platforms;
	}
}
