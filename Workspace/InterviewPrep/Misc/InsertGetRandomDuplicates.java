package Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class InsertGetRandomDuplicates {
	class RandomizedCollection {

		HashMap<Integer, HashSet<Integer>> map = null;
		ArrayList<Integer> list = null;

		/** Initialize your data structure here. */
		public RandomizedCollection() {
			map = new HashMap<>();
			list = new ArrayList<>();
		}

		/**
		 * Inserts a value to the collection. Returns true if the collection did not
		 * already contain the specified element.
		 */
		public boolean insert(int val) {
			if (map.containsKey(val)) {
				map.get(val).add(list.size());
				list.add(val);
				return false;
			} else {
				map.put(val, new HashSet<>());
				map.get(val).add(list.size());
				list.add(val);
				return true;
			}
		}

		/**
		 * Removes a value from the collection. Returns true if the collection contained
		 * the specified element.
		 */
		public boolean remove(int val) {
			if (!map.containsKey(val)) {
				return false;
			} else {
				HashSet<Integer> set = map.get(val);
				int index = set.iterator().next();

				int lastElement = list.get(list.size() - 1);
				HashSet<Integer> lastElementset = map.get(lastElement);
				// update the list
				list.set(index, lastElement);

				// remove the index from the set of val
				set.remove(index);

				if (index < list.size() - 1) {
					// update the map of lastElement
					lastElementset.remove(list.size() - 1);
					lastElementset.add(index);
				}

				// remove from the list
				list.remove(list.size() - 1);

				// check set size of val
				if (set.size() == 0) {
					map.remove(val);
				}
				return true;
			}
		}

		/** Get a random element from the collection. */
		public int getRandom() {
			Random random = new Random();
			return list.get(random.nextInt(list.size()));
		}
	}

	/**
	 * Your RandomizedCollection object will be instantiated and called as such:
	 * RandomizedCollection obj = new RandomizedCollection(); boolean param_1 =
	 * obj.insert(val); boolean param_2 = obj.remove(val); int param_3 =
	 * obj.getRandom();
	 */
}
