package Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class minCostOfRopes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(minCost(arr));
		}
	}

	static long minCost(int[] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}
		long cost = 0;
		while (pq.size() != 1) {
			int v1 = pq.remove();
			int v2 = pq.remove();
			pq.add(v1 + v2);
			cost += (v1 + v2);
		}
		return cost;
	}

}
