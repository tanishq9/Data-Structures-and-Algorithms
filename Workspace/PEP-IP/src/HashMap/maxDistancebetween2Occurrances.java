package HashMap;

import java.util.HashMap;

public class maxDistancebetween2Occurrances {
	class Pair {
		int fo;
		int lo;

		Pair(int ifo, int ilo) {
			this.fo = ifo;
			this.lo = ilo;
		}
	}

	int maxDistance(int arr[], int n) {
		HashMap<Integer, Pair> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < n; i++) {
			int element = arr[i];
			// update first occurrence
			if (!map.containsKey(element)) {
				map.put(element, new Pair(i, -1));
			} else {
				// update the last occurrence
				int foe = map.get(element).fo;
				map.put(element, new Pair(foe, i));
				// find max distance
				max = Math.max(max, i - foe);
			}
		}
		return max;
	}
}
