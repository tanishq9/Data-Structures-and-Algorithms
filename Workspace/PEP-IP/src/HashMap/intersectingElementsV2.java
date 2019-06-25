package HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class intersectingElementsV2 {
	public static int[] intersect(int[] nums1, int[] nums2) {
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> hmap = new HashMap<>();
		for (int val : nums1) {
			hmap.put(val, hmap.getOrDefault(val, 0) + 1);
		}

		for (int val : nums2) {
			if (hmap.containsKey(val)) {
				list.add(val);
				hmap.put(val, hmap.get(val) - 1);
				if (hmap.get(val) == 0) {
					hmap.remove(val);
				}
			}
		}
		if (list.size() == 0) {
			return null;
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = (Integer) list.get(i);
		}
		return res;
	}
}
