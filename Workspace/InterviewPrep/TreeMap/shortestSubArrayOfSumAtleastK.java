package TreeMap;

import java.util.TreeMap;

public class shortestSubArrayOfSumAtleastK {
	public int shortestSubarray(int[] arr, int k) {
		TreeMap<Integer, Integer> tree = new TreeMap<>();
		int rsum = 0;
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			rsum += arr[i];
			if (rsum >= k) {
				minLen = Math.min(minLen, i + 1);
			}
			Integer floorKey = tree.floorKey(rsum - k);
			while (floorKey != null) {
				if (i - tree.get(floorKey) < minLen) {
					minLen = i - tree.get(floorKey);
				}
				tree.remove(floorKey);
				floorKey = tree.lowerKey(floorKey);
			}
			tree.put(rsum, i);
		}
		return minLen != Integer.MAX_VALUE ? minLen : -1;
	}
}
