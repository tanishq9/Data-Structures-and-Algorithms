package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class maxHistogram {

	public static void main(String[] args) {
		int[] arr = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println(findRectArea(arr));
		ArrayList<Integer> list = new ArrayList<>();
		list.add(6);
		list.add(2);
		list.add(5);
		list.add(4);
		list.add(5);
		list.add(1);
		list.add(6);
		System.out.println(findA(list));
	}

	private static int findRectArea(int[] arr) {
		int n = arr.length;
		int[] lb = new int[n];
		int[] rb = new int[n];
		int max = Integer.MIN_VALUE;

		// Construct right boundary
		rb[n - 1] = n;
		Stack<Integer> stack = new Stack<>();
		for (int i = n - 2; i >= 0; i--) {
			while (stack.size() > 0 && arr[stack.peek()] > arr[i]) {
				stack.pop();
			}
			rb[i] = stack.size() > 0 ? stack.peek() : n;
			stack.push(i);
		}
		for (int i = 0; i < n; i++) {
			System.out.print(rb[i] + " ");
		}
		System.out.println();
		// Construct the left boundary
		stack = new Stack<>();
		lb[0] = -1;
		for (int i = 1; i < n; i++) {
			while (stack.size() > 0 && arr[stack.peek()] > arr[i]) {
				stack.pop();
			}
			lb[i] = stack.size() > 0 ? stack.peek() : -1;
			stack.push(i);
		}
		for (int i = 0; i < n; i++) {
			System.out.print(lb[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			if (rb[i] == -1) {
				rb[i] = arr.length;
			}
			max = Math.max((rb[i] - lb[i] - 1) * arr[i], max);
			System.out.println((rb[i] - lb[i] - 1) * arr[i]);
		}
		return max;
	}

	private static int findA(ArrayList<Integer> A) {
		int n = A.size();
		int lb[] = new int[n];
		int rb[] = new int[n];
		// Construct the left boundary
		lb[0] = -1;
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i < n; i++) {
			while (stack.size() > 0 && A.get(stack.peek()) >= A.get(i)) {
				stack.pop();
			}
			lb[i] = stack.size() > 0 ? stack.peek() : -1;
			stack.push(i);
		}
		for (int i = 0; i < n; i++) {
			System.out.print(lb[i] + " ");
		}
		System.out.println();
		// Construct the right boundary
		rb[n - 1] = n;
		stack = new Stack<>();
		for (int i = n - 2; i >= 0; i--) {
			while (stack.size() > 0 && A.get(stack.peek()) >= A.get(i)) {
				stack.pop();
			}
			rb[i] = stack.size() > 0 ? stack.peek() : n;
			stack.push(i);
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, (rb[i] - lb[i] - 1) * A.get(i));
		}
		for (int i = 0; i < n; i++) {
			System.out.print(rb[i] + " ");
		}
		System.out.println();
		return max;
	}

}
