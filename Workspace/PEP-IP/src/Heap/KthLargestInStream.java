package Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestInStream {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int i = 0; i < k; i++) {
				pq.add(arr[i]);
			}
			for (int i = 0; i < n; i++) {
				if (i < (k - 1)) {
					System.out.print("-1 ");
				} else if (i == (k - 1)) {
					System.out.print(pq.peek() + " ");
				} else if (i > (k - 1)) {
					if (arr[i] > pq.peek()) {
						pq.remove();
						pq.add(arr[i]);
					}
					System.out.print(pq.peek() + " ");
				}
			}
			System.out.println();
		}
	}
}
