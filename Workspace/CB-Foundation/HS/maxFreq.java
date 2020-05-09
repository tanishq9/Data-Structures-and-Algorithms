package HS;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

public class maxFreq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hashMap = new HashMap<>();
		hashMap.put("India", 40);
		// System.out.println(hashMap.get("India"));
		// System.out.println(hashMap.containsKey("India"));
		// This is how we declare set in java

		/*
		 * Set<Integer> set = new HashSet<>(); set.add(3); set.add(3); set.add(2);
		 * System.out.println(set);
		 */
		/*
		 * Collection<Integer> collection = hashMap.values(); Set<String> keys =
		 * hashMap.keySet(); for (String key : keys) { System.out.println(key); }
		 * Set<Map.Entry<String, Integer>> eset = hashMap.entrySet(); for
		 * (Map.Entry<String, Integer> entry : eset) {
		 * System.out.println(entry.getKey()); System.out.println(entry.getValue()); }
		 */
		int[] arr = { 1, 2, 3, 3, 4, 5 };
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}
		Set<Map.Entry<Integer, Integer>> eset = map.entrySet();
		int max = 0;
		for (Map.Entry<Integer, Integer> entry : eset) {
			// System.out.println(entry.getKey() + "->" + entry.getValue());
			if (entry.getValue() > max) {
				max = entry.getKey();
			}
		}
		HashMap<Integer, Integer> map2 = new HashMap<>();
		// System.out.println(max);
		int[] arr2 = { 1, 3, 1, 4, 5, 2, 3, 4, 5 };
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr2.length; i++) {
			if (!map2.containsKey(arr2[i])) {
				map2.put(arr2[i], 1);
			} else if (map2.containsKey(arr2[i])) {
				map2.put(arr2[i], 0);
			}
		}
		Set<Map.Entry<Integer, Integer>> eset2 = map2.entrySet();
		for (Map.Entry<Integer, Integer> entry : eset2) {
			// System.out.println(entry.getKey() + "->" + entry.getValue());
			if (entry.getValue() == 0) {
				list.add(entry.getKey());
			}
		}

		// System.out.println(list);
		int ans = 0;
		HashMap<Integer, Integer> hmap = new HashMap<>();
		int[] a = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		for (int i = 0; i < a.length; i++) {
			hmap.put(a[i], a[i]);
		}
		for (int i = 0; i < a.length; i++) {
			// TO check if the element is the starting point of some sequence or not
			if (!hmap.containsKey(a[i] - 1)) {
				int j = a[i];
				// Now check how many consecutive elements do we find in the map
				while (hmap.containsKey(j)) {
					j++;
				}
				// update the optimal length if required
				if (j - a[i] > ans) {
					ans = j - a[i];
				}
			}
		}
		System.out.println(ans);

	}

}
