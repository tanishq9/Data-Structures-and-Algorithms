package SubArray;

import java.util.HashMap;

public class countSubArrayWithEqual01 {
	public static int countSubArrays(int[] arr, int n) {
		HashMap<Integer, Integer> map = new HashMap<>();
		// difference in count0 and count1 and frequency
		map.put(0, 1);
		int count0 = 0;
		int count1 = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				count0++;
			} else {
				count1++;
			}
			int diff = count0 - count1;
			if (map.containsKey(diff)) {
				count += map.get(diff);
			}
			map.put(diff, map.getOrDefault(diff, 0) + 1);
		}
		return count;
	}

}
