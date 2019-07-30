package SubArray;

import java.util.Collections;
import java.util.PriorityQueue;

class MyMedianPQ {
	PriorityQueue<Integer> lo = null;
	PriorityQueue<Integer> hi = null;

	MyMedianPQ() {
		lo = new PriorityQueue<>(Collections.reverseOrder());
		hi = new PriorityQueue<>();
	}

	public void add(int num) {
		lo.add(num); // offer to max heap
		hi.add(lo.remove()); // balancing step
		if (lo.size() < hi.size()) { // maintain size property
			lo.add(hi.remove());
		}
	}

	public double peek() {
		return lo.size() > hi.size() ? lo.peek() : (((long) lo.peek() + hi.peek()) * 0.5);
	}

	public boolean remove(int num) {
		// removes one occurrance from either of the heap where it is found
		return lo.remove(num) || hi.remove(num);
	}
}

public class slidingWindowMedian {
	public double[] medianSlidingWindow(int[] arr, int k) {
		if (arr.length == 0 || arr == null) {
			return new double[0];
		}
		MyMedianPQ myheap = new MyMedianPQ();
		int start = 0;
		int end = 0;
		double[] result = new double[arr.length - k + 1];
		int idx = 0;
		while (end < arr.length) {
			myheap.add(arr[end]);
			if ((end - start + 1) == k) {
				result[idx++] = myheap.peek();
				myheap.remove(arr[start++]); // release
			}
			end++; // acquire
		}
		return result;
	}

}
