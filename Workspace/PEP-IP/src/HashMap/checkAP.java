package HashMap;

import java.util.HashSet;

public class checkAP {
	public static boolean checkAP(int[] arr) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		int d = (max - min) / (n - 1);
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(arr[i]);
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] != max && !set.contains(arr[i] + d)) {
				return false;
			}
		}
		return true;
	}

}
