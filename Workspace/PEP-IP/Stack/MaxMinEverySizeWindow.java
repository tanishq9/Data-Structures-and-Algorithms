package Stack;

import java.util.*;

public class MaxMinEverySizeWindow {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			maxminwindow(arr);
			System.out.println();
		}
	}

	static void maxminwindow(int[] arr) {
		int n = arr.length;
		int[] ans = new int[n + 1];
		int[] nsl = new int[n];
		int[] nsr = new int[n];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		nsl[0] = -1;
		for (int i = 1; i < n; i++) {
			while (stack.size() > 0 && arr[stack.peek()] >= arr[i]) {
				stack.pop();
			}
			nsl[i] = stack.size() > 0 ? stack.peek() : -1;
			stack.push(i);
		}
		stack = new Stack<>();
		stack.push(n - 1);
		nsr[n - 1] = n;
		for (int i = n - 2; i >= 0; i--) {
			while (stack.size() > 0 && arr[stack.peek()] >= arr[i]) {
				stack.pop();
			}
			nsr[i] = stack.size() > 0 ? stack.peek() : n;
			stack.push(i);
		}
		for (int i = 0; i < n; i++) {
			System.out.print(nsl[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.print(nsr[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			int windowSize = nsr[i] - nsl[i] - 1;
			ans[windowSize] = Math.max(ans[windowSize], arr[i]);
		}
		for (int i = n - 1; i >= 1; i--) {
			ans[i] = Math.max(ans[i], ans[i + 1]);
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
