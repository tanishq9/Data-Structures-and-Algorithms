package HashMap;

import java.util.HashMap;

public class kDiffPair {
	class Solution {
		public int findPairs(int[] arr, int k) {
			if (k < 0) {
				return 0;
			}
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < arr.length; i++) {
				map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			}
			int count = 0;
			for (int key : map.keySet()) {
				if (k == 0) {
					if (map.get(key) >= 2) {
						count++;
					}
				} else {
					if (map.containsKey(key - k)) {
						count++;
					}
				}
			}
			return count;
		}
	}
}
