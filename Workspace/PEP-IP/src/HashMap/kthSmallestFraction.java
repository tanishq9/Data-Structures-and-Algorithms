package HashMap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class kthSmallestFraction {
	static class Pair implements Comparable<Pair> {
		int i;
		int j;
		double val;

		Pair(int i, int j, double val) {
			this.i = i;
			this.j = j;
			this.val = val;
		}

		public int compareTo(Pair other) {
			if (this.val < other.val) {
				return -1;
			} else if (this.val > other.val) {
				return 1;
			} else {
				return 0;
			}
		}
	}	

	public static void kthsmallestfrac(int[] arr, int k) {
		int j = arr.length - 1;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int i = 0; i <= arr.length - 2; i++) {
			pq.add(new Pair(i, j, arr[i] * 1.0 / arr[j]));
		}
		while (k-- > 1) {
			System.out.println(arr[pq.peek().i] + "/" + arr[pq.peek().j] + " " + pq.peek().val);
			Pair top = pq.remove();
			if ((top.j - 1) > top.i) {
				pq.add(new Pair(top.i, top.j - 1, arr[top.i] * 1.0 / arr[top.j - 1]));
			}
		}
		System.out.println(arr[pq.peek().i] + "/" + arr[pq.peek().j] + " " + pq.peek().val);
	}

	public static void main(String[] args) {
		// 5 7 2 3 5 7 11
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		kthsmallestfrac(arr, k);
	}

}
