package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class kSmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 15, 2, 17, 7, 18, 22, 9, 3 };
		// PQ space : O(n)
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// O(n*log(n)) : n additions in the heap
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]); // O(log(n))
		}
		int k = 4;
		// K*O(log(n))
		while (k-- > 0) {
			System.out.println(pq.peek());
			pq.remove();
		}
		// Another approach
		pq = new PriorityQueue<>(Collections.reverseOrder());
		k = 4;
		// O(k*log(k))
		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}
		// O((n-k)*log(k))
		// Therefore, total complexity : O([(n-k)+k)]*log(k))
		for (int i = k; i < arr.length; i++) {
			int top = pq.peek();
			if (arr[i] < top) {
				pq.remove();
				pq.add(arr[i]);
			}
		}
		System.out.println();
		// K*O(log(k))
		while (k-- > 0) {
			System.out.println(pq.peek());
			pq.remove();
		}
	}

}
