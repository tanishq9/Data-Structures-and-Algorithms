package SubArray;

import java.util.HashMap;

public class zeroSumSubarray {
	static void zerosumarr(long[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int rsum = 0, count = 0;
		map.put(rsum, 1);
		for (long i : arr) {
			rsum += i;
			if (map.containsKey(rsum)) {
				count += map.get(rsum);
			}
			map.put(rsum, map.getOrDefault(rsum, 0) + 1);
		}
		System.out.println(count);
	}
}
