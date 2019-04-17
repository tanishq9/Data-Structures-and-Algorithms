      package HashMap;

import java.util.HashMap;

public class longestConsequetiveElements {

	public static void main(String[] args) {
		int[] arr = { 2, 6, 1, 9, 4, 5, 3 };
		HashMap<Integer, Integer> hmap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			hmap.put(arr[i], 1);
		}
		int maxLength = 0;
		for (int i = 0; i < arr.length; i++) {
			int current = arr[i];
			int currentLength = 1;
			while (hmap.containsKey(current - 1)) {
				currentLength += 1;
				current -= 1;
			}
			maxLength = Math.max(maxLength, currentLength);
		}
		System.out.println(maxLength);
	}
}
