package SubArray;

import java.util.HashMap;

public class largest0SumSubarr {
	static int maxLen(int arr[], int n) {
		HashMap<Integer, Integer> map = new HashMap<>();
		// prefix sum and first occurrance
		map.put(0, -1);
		int max = 0;
		int rsum = 0;
		for (int i = 0; i < n; i++) {
			rsum += arr[i];
			if (map.containsKey(rsum)) {
				// prefix sum is always including that element i.e
				// yaha tak - jaha tak pehle tha
				max = Math.max(max, i - map.get(rsum));
			} else {
				map.put(rsum, i);
			}
		}
		return max;
	}

}
