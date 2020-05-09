package Stack;

import java.util.Scanner;
import java.util.Stack;

public class nge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				try {
					arr[i] = Long.parseLong(sc.next());
				} catch (NumberFormatException ex) { // handle your exception
					return;
				}
			}
			long[] nge = new long[n];
			nge[n - 1] = -1;
			Stack<Long> stack = new Stack<>();
			stack.push(arr[n - 1]);
			for (int i = n - 2; i >= 0; i--) {
				while (stack.size() > 0 && arr[i] > stack.peek()) {
					stack.pop();
				}
				nge[i] = stack.size() > 0 ? stack.peek() : -1;
				/*
				 * if (stack.size() > 0) { nge[i] = stack.peek(); } else { nge[i] = -1; }
				 */
				stack.push(arr[i]);
			}
			for (int i = 0; i < n; i++) {
				System.out.print(nge[i] + " ");
			}
			System.out.println();
		}
	}
}
