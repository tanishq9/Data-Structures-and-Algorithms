package StackImplementation;

import java.util.Stack;

public class StockSpan {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		int[] arr = { 100, 80, 60, 70, 60, 75, 85 };
		int[] span = new int[arr.length];
		stack.push(0);
		span[0] = stack.peek();
		for (int day = 1; day < arr.length; day++) {
			int current_day = arr[day];
			while (arr[stack.peek()] < current_day) {
				stack.pop();
			}
			span[day] = day - stack.peek();
			stack.push(span[day]);
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(span[i] + " ");
		}
	}
}
