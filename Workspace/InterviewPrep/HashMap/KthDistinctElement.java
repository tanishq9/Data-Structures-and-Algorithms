package HashMap;

import java.util.HashMap;

public class KthDistinctElement {
	public static int kthDistinctElement(int arr[], int k) {
		// Write your code here
		HashMap<Integer, Integer> map = new HashMap<>();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		int e = 0;
		for (int i = 0; i < n; i++) {
			if (map.get(arr[i]) == 1) {
				e++;
				if (e == k) {
					return arr[i];
				}
			}
		}
		return -1;
	}
}
