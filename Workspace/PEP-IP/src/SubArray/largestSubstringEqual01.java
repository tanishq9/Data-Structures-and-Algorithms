package SubArray;

import java.util.HashMap;

public class largestSubstringEqual01 {
	public static void print(char[] A) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int count0 = 0;
		int count1 = 0;
		int max = 0;
		map.put(count0 - count1, -1);
		for (int i = 0; i < A.length; i++) {
			char cc = A[i];
			if (cc == '0') {
				count0++;
			} else {
				count1++;
			}
			if (map.containsKey(count0 - count1)) {
				max = Math.max(max, i - map.get(count0 - count1));
			} else {
				map.put(count0 - count1, i);
			}
		}
		System.out.println(max);
	}
}
