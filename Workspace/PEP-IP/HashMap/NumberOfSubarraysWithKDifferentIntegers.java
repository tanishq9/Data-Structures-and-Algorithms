package HashMap;

import java.util.HashMap;

public class NumberOfSubarraysWithKDifferentIntegers {
	public int subarraysWithKDistinct(int[] A, int K) {
		return atMostKDistinct(A, K) - atMostKDistinct(A, K - 1);
	}

	private int atMostKDistinct(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int start = 0, end = 0, count = 0;
		boolean valid = true;
		while (end < arr.length) {
			map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
			if (map.size() > k) {
				valid = false;
			}
			// start releasing characters from the start and make it valid
			while (valid == false) {
				map.put(arr[start], map.get(arr[start]) - 1);
				if (map.get(arr[start]) == 0) {
					map.remove(arr[start]);
				}
				if (map.size() == k) {
					valid = true;
				}
				start++;
			}
			count += (end - start + 1); // update count
			end++; // acquire more
		}
		// example -> 1 2 3 4 : 1,2,12,123,23,3,1234,234,34,4
		// 1,2,1,3,4 and k=3
		// exactly 3 = atmost 3 - atmost 2
		// atmost 3 : 1,2,12,121,21,1,1213,213,13,3,134,34,4
		// atmost 2 : 1,2,12,121,21,1,13,3,34,4
		// left : 1213,213,134

		return count;
	}

}
