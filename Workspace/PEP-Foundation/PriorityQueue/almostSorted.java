package PriorityQueue;

import java.util.PriorityQueue;

public class almostSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 7, 15, 5, 22, 18, 20, 27, 35, 40, 30 };
		// O(n*log(k+1))
		getSorted(arr, 2);
	}

	public static void getSorted(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i <= k && i < arr.length; i++) {
			pq.add(arr[i]);
		}
		for (int i = k + 1; i < arr.length; i++) {
			System.out.print(pq.peek() + " ");
			pq.remove();
			pq.add(arr[i]);
		}
		while (!pq.isEmpty()) {
			System.out.print(pq.peek() + " ");
			pq.remove();
		}
	}

}
