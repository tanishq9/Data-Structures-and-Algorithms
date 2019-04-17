package IBit;

import java.util.ArrayList;

public class removingElementsFromList {
	public class Solution {
		public int removeElement(ArrayList<Integer> a, int b) {
			// list.remove() for removing at a particular index and
			// list.removeAll() for removing particular elements from list
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(b);
			a.removeAll(list);
			return a.size();
		}
	}
}
