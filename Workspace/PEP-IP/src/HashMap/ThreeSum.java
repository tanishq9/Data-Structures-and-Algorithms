package HashMap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] arr) {
		int n = arr.length;
		List<List<Integer>> res = new LinkedList<>();
		Arrays.sort(arr);
		for (int i = 0; i <= n - 3; i++) {
			// For uniqueness of solution
			// Leet_code accepts only unique subset of 3 elements summing to 0
			if (i == 0 || i > 0 && arr[i] != arr[i - 1]) {
				int s = i + 1;
				int e = n - 1;
				while (s < e) {
					int curr = arr[s] + arr[e] + arr[i];
					if (curr < 0) {
						while (s < e && arr[s] == arr[s + 1]) {
							s++;
						}
						s++;
					} else if (curr == 0) {
						res.add(Arrays.asList(arr[i], arr[s], arr[e]));
						while (s < e && arr[s] == arr[s + 1]) {
							s++;
						}
						while (s < e && arr[e] == arr[e - 1]) {
							e--;
						}
						s++;
						e--;
					} else {
						while (s < e && arr[e] == arr[e - 1]) {
							e--;
						}
						e--;
					}
				}
			}
		}
		return res;
	}
}
