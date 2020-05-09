package StackQueues;

import java.util.ArrayList;
import java.util.Stack;

public class nextSmallerElement {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> nse = new ArrayList<>();
		A.add(1);
		A.add(9);
		A.add(2);
		A.add(3);
		nse.add(-1);
		stack.push(A.get(0));
		for (int i = 1; i < A.size(); i++) {
			while (!stack.isEmpty() && stack.peek() > A.get(i)) {
				stack.pop();
			}
			if (!stack.empty()) {
				nse.add(i, stack.peek());
			} else {
				nse.add(i, -1);
			}
			stack.push(A.get(i));
		}
		System.out.println(nse);
	}

}
