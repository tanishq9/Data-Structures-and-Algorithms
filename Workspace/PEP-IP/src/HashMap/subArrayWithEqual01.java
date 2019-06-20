package HashMap;

import java.util.HashMap;

public class subArrayWithEqual01 {
	static int count(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int count0 = 0, count1 = 0, ans = 0;
		map.put(0, 1); // count0[i]-count1[i] = count0[j]-count1[j]
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				count0++;
			} else {
				count1++;
			}
			int diff = count0 - count1;
			if (map.containsKey(diff)) {
				ans += map.get(diff);
				map.put(diff, map.get(diff) + 1);
			} else {
				map.put(diff, 1);
			}
		}
		return ans;
	}
}
