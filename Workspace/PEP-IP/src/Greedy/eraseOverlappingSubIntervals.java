package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class eraseOverlappingSubIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0) {
			return 0;
		}
		// sort by end
		// because the interval that end early the we will have more space to accomodate
		// other intervals
		Interval[] interval = new Interval[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			interval[i] = new Interval(intervals[i][0], intervals[i][1]);
		}
		Arrays.sort(interval, new Comparator<Interval>() {
			public int compare(Interval f, Interval s) {
				return f.end - s.end;
			}
		});

		int count = 0;
		int global_end = interval[0].end;
		for (int i = 1; i < interval.length; i++) {
			if (interval[i].start < global_end) {
				count++;
			} else {
				global_end = interval[i].end;
			}
		}
		return count;
	}

	class Interval {
		int start;
		int end;

		Interval(int is, int ie) {
			this.start = is;
			this.end = ie;
		}
	}
}
