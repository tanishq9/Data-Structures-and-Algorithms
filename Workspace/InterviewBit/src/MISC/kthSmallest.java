package IBit;

import java.util.List;
import java.util.PriorityQueue;

public class kthSmallest {
	public class Solution {
		// DO NOT MODIFY THE LIST. IT IS READ ONLY
		public int kthsmallest(final List<Integer> A, int B) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int i = 0; i < A.size(); i++) {
				pq.add(A.get(i));
			}
			/*
			 * while(!pq.isEmpty()){ System.out.print(pq.peek()+" "); pq.remove(); }
			 */
			for (int i = 1; i < B; i++) {
				pq.remove();
			}
			return pq.peek();
		}
	}

}
