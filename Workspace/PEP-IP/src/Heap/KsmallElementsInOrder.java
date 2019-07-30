package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KsmallElementsInOrder {
	public static void print_k_smallest_elements_in_their_original_order(int n, int k, int[] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		// 0(n*log(k))
		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}
		for (int i = k; i < n; i++) {
			int curr = arr[i];
			if (curr < pq.peek()) {
				pq.remove();
				pq.add(arr[i]);
			}
		}
		// Without using extra space we print the k smallest elements in order
		for (int i = 0; i < n; i++) {
			if (pq.size() == 0) {
				break;
			}
			if (arr[i] < pq.peek()) {
				System.out.print(arr[i] + " ");
			} else if (arr[i] == pq.peek()) {
				System.out.print(arr[i] + " ");
				pq.remove();
			}
		}
	}

}
