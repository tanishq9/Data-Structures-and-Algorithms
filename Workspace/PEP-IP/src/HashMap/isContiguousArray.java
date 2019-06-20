package HashMap;

import java.util.HashSet;

public class isContiguousArray {
	public static boolean isContiguous(int[] arr) {
		HashSet<Integer> hset = new HashSet<>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int val : arr) {
			hset.add(val);
			min = Math.min(val, min);
			max = Math.max(val, max);
		}

		for (int i = min; i <= max; i++) {
			if (hset.contains(i) == false) {
				return false;
			}
		}

		return true;
	}
}
