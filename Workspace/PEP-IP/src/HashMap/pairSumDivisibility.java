package HashMap;

import java.util.HashMap;

public class pairSumDivisibility {

	public static boolean solve(int[] arr, int k) {
		if (arr.length % 2 != 0) {
			return false;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put((arr[i] % k + k) % k, map.getOrDefault((arr[i] % k + k) % k, 0) + 1);
		}
		for (int rem : map.keySet()) {
			if (rem == 0) {
				if (map.get(rem) % 2 != 0) {
					return false;
				}
			} else if (2 * rem == k) {
				if (map.get(rem) % 2 != 0) {
					return false;
				}
			} else {
				if (map.get(rem) != map.get(k - rem)) {
					return false;
				}
			}
		}
		return true;
	}

}
