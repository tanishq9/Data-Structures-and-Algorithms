package HashMap;

import java.util.HashMap;

public class numBoomerangs {
	class Solution {
		public int numberOfBoomerangs(int[][] points) {
			HashMap<Integer, Integer> map = new HashMap<>();
			int res = 0;
			// Har point ko i maan ke consider kar ki kitne j aur k ke saath distance equal
			// hai
			for (int i = 0; i < points.length; i++) {
				for (int j = 0; j < points.length; j++) {
					if (i == j) {
						continue;
					}
					int dist = getDistance(points[i], points[j]);
					map.put(dist, map.getOrDefault(dist, 0) + 1);
				}
				for (int val : map.values()) {
					res += val * (val - 1);
				}
				map.clear();
			}
			return res;
		}

		private int getDistance(int[] a, int[] b) {
			int dx = a[0] - b[0];
			int dy = a[1] - b[1];

			return dx * dx + dy * dy;
		}

	}
}
