package Heap;

import java.util.PriorityQueue;

public class kthLargestInStreamClassForm {
	class KthLargest {

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// We make a Min Heap , by default Java's PQ has Min Heap behavior
		int heap_size = 0;

		public KthLargest(int k, int[] nums) {
			heap_size = k;
			for (int i = 0; i < nums.length; i++) {
				add(nums[i]);
			}
		}

		public int add(int val) {
			if (pq.size() < heap_size) {
				pq.add(val);
			} else if (pq.size() >= heap_size) {
				if (val > pq.peek()) {
					pq.remove();
					pq.add(val);
				}
			}
			return pq.peek();
		}
	}

}
