package Arr;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PairswithDiff {

	public static void main(String[] args) {
		int count = 0;
		int[] arr = { 1, 5, 3, 4, 2 };
		HashMap<Integer, Boolean> hmap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			hmap.put(arr[i], true);
		}
		Set<Map.Entry<Integer, Boolean>> eset = hmap.entrySet();
		for (Map.Entry<Integer, Boolean> entry : eset) {
			if (hmap.containsKey(entry.getKey() + 1)) {
				if (hmap.get(entry.getKey() + 1)) {
					count++;
				}
			} else if (hmap.containsKey(entry.getKey() - 1)) {
				if (hmap.get(entry.getKey() - 1)) {
					count++;
				}
			}
			hmap.put(entry.getKey(), false);
		}
		System.out.println(count);
	}
}
