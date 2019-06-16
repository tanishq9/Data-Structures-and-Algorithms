package Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class nearlySorted {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			sort(arr, k);
			System.out.println();
		}

	}

	static void sort(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i <= k && i < arr.length; i++) {
			pq.add(arr[i]);
		}
		// O(n*log(k+1))
		for (int i = k + 1; i < arr.length; i++) {
			System.out.print(pq.remove() + " ");
			pq.add(arr[i]);
		}
		while (pq.size() > 0) {
			System.out.print(pq.remove() + " ");
		}
	}
}
