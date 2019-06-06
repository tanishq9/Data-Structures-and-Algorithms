package HashMap;

import java.util.HashMap;

public class countDistinctElementsInWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 1, 3, 4, 3 };
		int k = 3;
		HashMap<Integer, Integer> map = new HashMap<>();
		int cdi = 0;
		for (int i = 0; i < k; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
				cdi++;
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}
		System.out.println(cdi);
		for (int i = k; i < arr.length; i++) {
			// Remove the previous window start
			if (map.get(arr[i - k]) == 1) {
				map.remove(arr[i - k]);
				cdi--;
			} else {
				int count = map.get(arr[i - k]);
				map.put(arr[i - k], count - 1);
			}
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
				cdi++;
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
			System.out.println(cdi);
		}
	}

}
