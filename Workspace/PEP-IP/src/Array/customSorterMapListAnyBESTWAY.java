package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class customSorterMapListAnyBESTWAY {
	public static void main(String[] args) {
		int[] arr = { 4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5 };
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		ArrayList<Map.Entry<Integer, Integer>> slist = new ArrayList<>(map.entrySet());
		Collections.sort(slist, new sorter());

		System.out.println(slist);
		for (Map.Entry<Integer, Integer> entry : slist) {
			int freq = entry.getValue();
			while (freq-- > 0) {
				System.out.print(entry.getKey() + " ");
			}
		}
	}

	static class sorter implements Comparator<Map.Entry<Integer, Integer>> {

		@Override
		public int compare(Entry<Integer, Integer> k1, Entry<Integer, Integer> k2) {
			if (k1.getValue() > k2.getValue()) {
				return -1;
			} else if (k1.getValue() == k2.getValue()) {
				return k1.getKey() > k2.getKey() ? 1 : -1;
			} else {
				return 1;
			}
		}
	}
}
