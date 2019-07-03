package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class videoStitching {
	class Solution {
		public int videoStitching(int[][] clips, int T) {
			if (clips.length == 0) {
				return -1;
			}
			// sort the clips by starting time
			// analyze where each clip can extend to maximum
			// check if the maximum end reaches the target
			Arrays.sort(clips, new Comparator<int[]>() {
				public int compare(int[] f, int[] s) {
					return f[0] - s[0];
				}
			});
			int i = 0; // index of first segment
			int currEnd = 0, maxEnd = 0;
			int segments = 0;
			while (i < clips.length) {
				if (maxEnd < clips[i][0]) {
					return -1;
				}
				// consider this segment
				segments++;

				while (i < clips.length && clips[i][0] <= currEnd) {
					maxEnd = Math.max(maxEnd, clips[i][1]);
					i++; // keep looping till we can work on the same segment
				}
				currEnd = maxEnd;
				if (currEnd >= T) {
					return segments;
				}
				// move to the next segment and see where that can extend till maximum
			}
			return -1;
		}
	}
}
