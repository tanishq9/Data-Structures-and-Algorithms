package Stack;

import java.util.Stack;

public class stockSpan {

	public static void main(String[] args) {
		int[] stock = { 100, 80, 60, 70, 60, 75, 85 };
		int[] left_boundary = new int[stock.length];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		left_boundary[0] = 1;
		for (int i = 1; i < stock.length; i++) {
			while (!stack.isEmpty() && stock[stack.peek()] < stock[i]) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				left_boundary[i] = i - stack.peek();
			} else {
				left_boundary[i] = i + 1;
			}
			stack.push(i);
		}
		for (int i = 0; i < stock.length; i++) {
			System.out.print(left_boundary[i] + " ");
		}
	}

}
