package Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class minSumFormed {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				pq.add(arr[i]);
			}
			long num1 = 0, num2 = 0;
			boolean flag = true;
			while (pq.size() > 0) {
				int top = pq.remove();
				if (flag == true) {
					num1 = num1 * 10 + top;
				} else {
					num2 = num2 * 10 + top;
				}
				flag = !flag;
			}
			long sum = num1 + num2;
			System.out.println(sum);
		}
	}
}
