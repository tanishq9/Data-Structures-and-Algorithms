package Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertGetRandom {
	class RandomizedSet {

		// map of index and value, same as if we are maintaining an arraylist
		HashMap<Integer, Integer> map = null;
		ArrayList<Integer> list = null;

		/** Initialize your data structure here. */
		public RandomizedSet() {
			map = new HashMap<>();
			list = new ArrayList<>();
		}

		/**
		 * Inserts a value to the set. Returns true if the set did not already contain
		 * the specified element.
		 */
		public boolean insert(int val) {
			if (map.containsKey(val)) {
				return false;
			} else {
				map.put(val, list.size());
				list.add(val);
				return true;
			}
		}

		/**
		 * Removes a value from the set. Returns true if the set contained the specified
		 * element.
		 */
		public boolean remove(int val) {
			if (!map.containsKey(val)) {
				return false;
			} else {
				// get index of the removed element
				int index = map.get(val);

				// removal from list end is O(1),so copy value at end at removal idx
				int lastElement = list.get(list.size() - 1);
				list.set(index, lastElement);
				// also update the map
				map.put(lastElement, index);

				// remove from map and list
				list.remove(list.size() - 1);
				map.remove(val);
				return true;
			}
		}

		/** Get a random element from the set. */
		public int getRandom() {
			Random random = new Random();
			// bound on the random number return is passed as parameter
			// 0,bound ; bound is exclusive
			return list.get(random.nextInt(list.size()));
		}
	}

	/**
	 * Your RandomizedSet object will be instantiated and called as such:
	 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
	 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
	 */
}
