package HashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class doublePairArray {
	public boolean canReorderDoubled(int[] A) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int x : A) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		// put all the unique values in arraylist
		ArrayList<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list);
		for (int x : list) {
			int count = map.get(x);
			// implying this x has been fully consumed
			if (count == 0) {
				continue;
			}
			int want = x;
			// find the want depending upon x is negative or positive
			if (x == 0) {
				// if count of 0 is odd then it can never be satisfied
				if (count % 2 == 1) {
					return false;
				}
			} else {
				if (x < 0) {
					// if the number is negative then we need to find its half to pair up
					// eg -22 needs -11 to pair up
					// if we have -23 then we cannot pair it up with anything
					// so return false
					if (x % 2 == 1) {
						return false;
					}
					want /= 2;
				} else {
					// eg 25 needs 50 to pair up
					want *= 2;
				}
			}
			// if our count is more than want , then we can never be satisfied
			if (count > map.getOrDefault(want, 0)) {
				return false;
			}
			map.put(want, map.get(want) - map.get(x));
		}
		return true;
	}
}
