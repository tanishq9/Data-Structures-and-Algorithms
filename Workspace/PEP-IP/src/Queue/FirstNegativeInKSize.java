package Queue;

import java.util.LinkedList;
import java.util.Scanner;

public class FirstNegativeInKSize {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int k = sc.nextInt();
			print(arr, k);
			System.out.println();
		}
	}

	static class Pair {
		int val;
		int idx;

		Pair(int iv, int ii) {
			this.val = iv;
			this.idx = ii;
		}
	}

	static void print(int[] arr, int k) {
		LinkedList<Pair> q = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				q.addLast(new Pair(arr[i], i));
			}
		}
		for (int i = 0; i <= (arr.length - k); i++) {
			if (q.size() > 0) {
				Pair front = q.getFirst();
				if (Math.abs(i - front.idx) < k) {
					System.out.print(front.val + " ");
				} else {
					System.out.print("0 ");
				}
				if (front.idx == i) {
					q.removeFirst();
				}
			} else {
				System.out.print("0 ");
			}

		}
	}
}
