package StackImplementation;

import java.util.Stack;

public class revstack {
	static Stack<Integer> helper = new Stack<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		for (int i = 5; i >= 1; i--) {
			stack.push(i);
		}
		reverseStack(stack);
		while (!stack.isEmpty()) {
			System.out.print(stack.peek() + " ");
			stack.pop();
		}
		// revStack(stack, 0);
		/*
		 * revStack(stack, 0); for (int i = 0; i <= stack.size() - 1; i++) {
		 * System.out.print(stack.get(i) + " "); }
		 */

	}

	private static void reverseStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int poppedElement = stack.peek();
		stack.pop();
		reverseStack(stack);
		insertAtBottom(stack, poppedElement);
	}

	private static void insertAtBottom(Stack<Integer> stack, int poppedElement) {
		if (stack.isEmpty()) {
			stack.push(poppedElement);
			return;
		}
		int i = stack.peek();
		stack.pop();
		insertAtBottom(stack, poppedElement);
		stack.push(i);
	}

	private static void revStack(Stack<Integer> stack, int level) {
		if (stack.size() == 0) {
			return;
		}
		int i = stack.peek();
		stack.pop();
		revStack(stack, level + 1);
		helper.push(i);
		if (level == 0) {
			while (!helper.isEmpty()) {
				stack.push(helper.pop());
			}
		}
		return;
	}

}
