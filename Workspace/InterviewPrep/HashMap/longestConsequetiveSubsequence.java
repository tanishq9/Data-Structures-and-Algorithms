package HashMap;

import java.util.HashMap;

public class longestConsequetiveSubsequence {
	public static int consecuitveSub(int n, int[] arr) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(arr[i], true);
		}
		for (int i = 0; i < n; i++) {
			if (map.containsKey(arr[i] - 1)) {
				map.put(arr[i], false);
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (map.get(arr[i]) == true) {
				int curr = arr[i];
				int len = 1;
				while (map.containsKey(curr + 1)) {
					curr++;
					len++;
				}
				max = Math.max(max, len);
			}
		}
		return max;
	}

}
