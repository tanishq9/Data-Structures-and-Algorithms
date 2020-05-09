package SubArray;

import java.util.HashMap;

public class subArraysSumDivisibleByK {
	public static int subarraysDivByK(int[] arr, int k) {

		// remainder and frequency map
		HashMap<Integer, Integer> map = new HashMap<>();
		int n = arr.length;
		int sum = 0;
		int rem = 0;
		int count = 0;
		map.put(rem, 1); // initialize the frequency map
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			rem = (sum % k + k) % k;
			// Increment the count
			if (map.containsKey(rem)) {
				count += map.get(rem);
			}
			// Update the frequency map
			map.put(rem, map.getOrDefault(rem, 0) + 1);
		}
		return count;
	}
}
