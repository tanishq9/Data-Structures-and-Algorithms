package Stack;

import java.util.Stack;

public class slidingWindow {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 1, 8, 5, 2, 9 };
		int k = 5;
		kmax(arr, k);
	}

	private static void kmax(int[] arr, int k) {
		int[] nextGreaterElementArray = new int[arr.length];
		Stack<Integer> stack = new Stack<>();

		nextGreaterElementArray[arr.length - 1] = Integer.MAX_VALUE;
		stack.push(arr.length - 1);

		for (int i = arr.length - 2; i >= 0; i--) {
			while (stack.size() > 0 && arr[i] > arr[stack.peek()]) {
				stack.pop();
			}
			nextGreaterElementArray[i] = stack.peek();
			stack.push(i);
		}
		/*
		 * for (int i = 0; i < arr.length; i++) {
		 * System.out.print(nextGreaterElementArray[i] + " "); }
		 */
		int j = 0;
		for (int i = 0; i <= arr.length - k; i++) {
			if (j < i) {
				j = i;
			}
			while (nextGreaterElementArray[j] < i + k) {
				j = nextGreaterElementArray[j];
			}
			System.out.println(arr[j]);
		}
	}

}
