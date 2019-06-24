package HashMap;

import java.util.HashMap;

public interface sumOfLengthOfSubArrHavingDistinctElements {
	public static int sumLength(int[] arr) {
		// Write your code here
		HashMap<Integer, Integer> map = new HashMap<>();
		int start = 0;
		int end = 0;
		int count = 0;
		boolean valid = true;
		while (end < arr.length) {
			map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
			if (map.get(arr[end]) > 1) {
				valid = false;
			}
			while (valid == false) {
				map.put(arr[start], map.get(arr[start]) - 1);
				if (arr[start] == arr[end]) {
					valid = true;
				}

				count += (((end - 1) - start + 1) * ((end - 1) - start + 2)) / 2;
				start++;
			}
			end++;
		}
		while (start != end) {
			count += (((end - 1) - start + 1) * ((end - 1) - start + 2)) / 2;
			start++;
		}

		return count;
	}
}
