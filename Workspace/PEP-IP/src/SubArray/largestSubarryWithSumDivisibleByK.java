package SubArray;

import java.util.HashMap;

public class largestSubarryWithSumDivisibleByK {
	public static void print(int n, int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		// remainder and first occurrance
		map.put(0, -1);
		int max = 0;
		int rem = 0;
		int rsum = 0;
		for (int i = 0; i < n; i++) {
			rsum += arr[i];
			rem = (rsum % k + k) % k;
			if (map.containsKey(rem)) {
				// prefix sum is always including that element i.e
				// yaha tak - jaha tak pehle tha
				max = Math.max(max, i - map.get(rem));
			} else {
				map.put(rem, i);
			}
		}
		System.out.println(max);
	}
}
