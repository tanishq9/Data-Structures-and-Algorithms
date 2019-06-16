package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class sortElementsByFrequency {

	static class Pair implements Comparable<Pair> {
		int val;
		int freq;

		Pair(int ival, int ifreq) {
			this.val = ival;
			this.freq = ifreq;
		}

		public int compareTo(Pair other) {
			if (this.freq > other.freq) {
				return -1;
			} else if (this.freq < other.freq) {
				return 1;
			} else {
				return 0;
			}
		}

		public static Comparator<Pair> freqComp = new Comparator<Pair>() {
			public int compare(Pair one, Pair two) {
				if (one.freq > two.freq) {
					return -1;
				} else if (one.freq < two.freq) {
					return 1;
				} else {
					return 0;
				}
			}
		};
	}

	// in case you want to have more than way of sorting
	// your class objects you should use comparators.

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

		ArrayList<Pair> list = new ArrayList<>();
		for (int key : map.keySet()) {
			Pair p = new Pair(key, map.get(key));
			list.add(p);
		}
		Collections.sort(list, Pair.freqComp);
		for (Pair element : list) {
			int freq = element.freq;
			while (freq-- > 0) {
				System.out.print(element.val + " ");
			}
		}

		ArrayList<Map.Entry<Integer, Integer>> slist = new ArrayList<>(map.entrySet());
		Collections.sort(slist, new sorter());
	}

	static class sorter implements Comparator<Map.Entry<Integer, Integer>> {

		@Override
		public int compare(Entry<Integer, Integer> k1, Entry<Integer, Integer> k2) {
			return k1.getValue() - k2.getValue() > 0 ? -1 : 1;
		}

	}

}
