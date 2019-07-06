package SubArray;

import java.util.HashMap;

public class distinctElementsInSubarray {
	void countDistinct(int arr[], int k, int n) {
		// HashMap and 2 pointer approach
		HashMap<Integer, Integer> map = new HashMap<>();
		int start = 0;
		int end = 0;
		while (end < n) {
			int iend = arr[end];
			map.put(iend, map.getOrDefault(iend, 0) + 1);
			end++;
			if ((end - start) == k) {
				System.out.print(map.size() + " ");
				int istart = arr[start];
				map.put(istart, map.get(istart) - 1);
				if (map.get(istart) == 0) {
					map.remove(istart);
				}
				start++;
			}
		}
	}
}
