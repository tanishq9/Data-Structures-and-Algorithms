package IBit;

import java.util.ArrayList;

public class BSInsertPosition {

	public class Solution {

		private int nextGreater(ArrayList<Integer> a, int b) {
			int ans = -1, start = 0, end = a.size() - 1, mid = 0;
			Boolean found = false;
			while (start <= end) {
				mid = (start + end) / 2;
				if (a.get(mid) > b) {
					end = mid - 1;
				} else {
					if (a.get(mid) == b) {
						found = true;
					}
					ans = mid;
					start = mid + 1;
				}
			}
			if (found) {
				return ans;
			}
			return ans + 1;
		}

		public int searchInsert(ArrayList<Integer> a, int b) {
			if (a.get(0) > b) {
				return 0;
			}
			return nextGreater(a, b);
		}
	}
}