package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPQ {

	static class MedianPriorityQueue {
		// For larger elements : visualize on the right side
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		// For smaller elements : visualize on the left side
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		// If size is 0 for Median Heap , then add in Minimum Heap for larger elements
		// I will add in right side (Minimum Heap) by default
		// After every addition , I will balance out the tree
		void add(int val) {
			if (maxHeap.size() > 0 && val < maxHeap.peek()) {
				maxHeap.add(val);
			} else {
				minHeap.add(val);
			}
			handleBalance();
		}

		void handleBalance() {
			// If difference between the heap sizes is greater than 1
			// then remove and add accordingly : similar to AVL property
			if (minHeap.size() - maxHeap.size() == 2) {
				int val = minHeap.peek();
				minHeap.remove();
				maxHeap.add(val);
			} else if (minHeap.size() - maxHeap.size() == -2) {
				int val = maxHeap.peek();
				maxHeap.remove();
				minHeap.add(val);
			}
		}

		void remove() {
			if (minHeap.size() <= maxHeap.size()) {
				maxHeap.remove();
			} else {
				minHeap.remove();
			}
		}

		int peek() {
			if (minHeap.size() <= maxHeap.size()) {
				return maxHeap.peek();
			} else {
				return minHeap.peek();
			}
		}
	}

	public static void main(String[] args) {
		MedianPriorityQueue mpq = new MedianPriorityQueue();
		mpq.add(10);
		mpq.add(20);
		mpq.add(5);
		mpq.add(50);
		mpq.add(30);
		System.out.println(mpq.peek());
		mpq.remove();
		mpq.add(80);
		System.out.println(mpq.peek());
		mpq.add(100);
		mpq.add(110);
		System.out.println(mpq.peek());
		while (mpq.minHeap.size() > 0 && mpq.maxHeap.size() > 0) {
			System.out.println(mpq.peek());
			mpq.remove();
		}
		while (mpq.minHeap.size() > 0) {
			System.out.println(mpq.peek());
			mpq.remove();
		}
		while (mpq.maxHeap.size() > 0) {
			System.out.println(mpq.peek());
			mpq.remove();
		}
	}

}
