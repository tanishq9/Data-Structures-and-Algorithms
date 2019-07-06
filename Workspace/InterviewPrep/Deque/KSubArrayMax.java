package Deque;

import java.util.LinkedList;

public class KSubArrayMax {
	public int[] maxSlidingWindow(int[] arr, int k) {
		if (arr == null || k <= 0) {
			return new int[0];
		}
		int[] max = new int[arr.length - k + 1];
		int idx = 0;
		LinkedList<Integer> dq = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			// Pop from front if element is out of window
			while (dq.size() > 0 && dq.getFirst() <= i - k) {
				dq.removeFirst();
			}
			// Maintain a decreasing sequence with the element at the front being maximum
			while (dq.size() > 0 && arr[dq.getLast()] < arr[i]) {
				dq.removeLast();
			}
			dq.addLast(i);
			if (i >= (k - 1)) {
				max[idx++] = arr[dq.getFirst()];
			}
		}
		return max;
	}
}
