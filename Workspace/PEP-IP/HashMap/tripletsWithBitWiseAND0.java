package HashMap;

import java.util.HashMap;

public class tripletsWithBitWiseAND0 {
	public int countTriplets(int[] A) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : A) {
			for (int j : A) {
				map.put(i & j, map.getOrDefault(i & j, 0) + 1);
			}
		}
		int count = 0;
		for (int key : map.keySet()) {
			for (int i : A) {
				if ((i & key) == 0) {
					count += map.get(key);
				}
			}
		}
		return count;
	}
}
