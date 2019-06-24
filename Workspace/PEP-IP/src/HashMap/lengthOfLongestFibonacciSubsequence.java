package HashMap;

import java.util.HashMap;

public class lengthOfLongestFibonacciSubsequence {
	public int lenLongestFibSubseq(int[] arr) {
		// Given a strictly increasing array
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], 1);
		}
		int max = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int count = 0;
				int left = arr[i];
				int right = arr[j];
				while (map.containsKey(left + right)) {
					int temp = left + right;
					left = right;
					right = temp;
					count++;
				}
				if (count != 0) {
					count += 2;
					max = Math.max(max, count);
				}
			}
		}

		return max;
	}
}
