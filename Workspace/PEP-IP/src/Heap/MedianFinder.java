package Heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianFinder {
	// For larger elements : visualize on the right side
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	// For smaller elements : visualize on the left side
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

	public MedianFinder() {

	}

	public void addNum(int num) {
		maxHeap.add(num);
		minHeap.add(maxHeap.remove());
		if (maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.remove());
		}
	}

	public double findMedian() {
		return maxHeap.size() > minHeap.size() ? (double) maxHeap.peek() : ((minHeap.peek() + maxHeap.peek()) * 0.5);
	}

	public static void main(String[] argFs) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		MedianFinder mf = new MedianFinder();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			mf.addNum(sc.nextInt());
			System.out.println(mf.findMedian());
		}
	}
}
