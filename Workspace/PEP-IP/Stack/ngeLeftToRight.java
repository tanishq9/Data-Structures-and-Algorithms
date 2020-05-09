package Stack;

import java.util.Stack;

public class ngeLeftToRight {

	public static void main(String[] args) {
		int[] arr = { 100, 80, 60, 70, 60, 75, 85 };
		// next greater right to left
		Stack<Integer> stack = new Stack<>();
		int n = arr.length;
		int[] nge = new int[n];
		stack.push(arr[n - 1]);
		for (int i = n - 2; i >= 0; i--) {
			while (stack.size() > 0 && stack.peek() <= arr[i]) {
				stack.pop();
			}
			nge[i] = stack.size() > 0 ? stack.peek() : 0;
			stack.push(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(nge[i] + " ");
		}
		System.out.println();
		// next greater left to right
		stack = new Stack<>();
		nge = new int[n];
		stack.push(0);
		for (int i = 1; i < n; i++) {
			while (stack.size() > 0 && arr[stack.peek()] < arr[i]) {
				nge[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		while (stack.size() > 0) {
			nge[stack.pop()] = 0;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(nge[i] + " ");
		}
	}

}
