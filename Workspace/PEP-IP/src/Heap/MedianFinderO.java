package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinderO {
	class MedianFinder {

		PriorityQueue<Integer> minheap = new PriorityQueue<>(Collections.reverseOrder()); // for larger elements
		PriorityQueue<Integer> maxheap = new PriorityQueue<>(); // for smaller elements

		/** initialize your data structure here. */
		public MedianFinder() {

		}

		public void addNum(int num) {
			maxheap.add(num); // intially add to max heap of smaller elements
			minheap.add(maxheap.remove()); // offer the largest element to min heap which contains the large elements
			// check balance or make balance
			// also ensures that the max heap always has equal or more than one element than
			// in the min heap
			if (maxheap.size() < minheap.size()) {
				// maintain size balance property
				maxheap.add(minheap.remove());
			}
		}

		public double findMedian() {
			return maxheap.size() > minheap.size() ? maxheap.peek() : ((minheap.peek() + maxheap.peek()) * 0.5);
		}
	}
}
