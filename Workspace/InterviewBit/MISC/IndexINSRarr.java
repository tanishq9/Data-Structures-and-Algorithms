package IBit;

import java.util.ArrayList;

public class IndexINSRarr {

	public class Solution {
		// DO NOT MODIFY THE LIST
		private int search(ArrayList<Integer> A, int b, int low, int high) {
			if (low > high) {
				return -1;
			}
			int mid = (low + high) / 2;
			if (A.get(mid) == b) {
				return mid;
			}
			// If the left part is sorted
			if (A.get(low) <= A.get(mid)) {
				if (A.get(low) <= b && b <= A.get(mid)) {
					return search(A, b, low, mid - 1);
				} else {
					return search(A, b, mid + 1, high);
				}
			} else {
				if (A.get(mid) <= b && b <= A.get(high)) {
					return search(A, b, mid + 1, high);
				} else {
					return search(A, b, low, mid - 1);
				}
			}

		}

		public int search(ArrayList<Integer> a, int b) {
			return search(a, b, 0, a.size() - 1);
		}
	}
}