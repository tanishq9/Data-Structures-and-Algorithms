package StackQueues;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {

	public static void main(String[] args) {
		ArrayList<String> A = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		A.add("12");
		A.add("1");
		A.add("+");
		A.add("-3");
		A.add("*");
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i).length() > 1) {
				stack.push(Integer.valueOf(A.get(i)));
			} else {
				char cc = A.get(i).charAt(0);
				int offset = cc - '0';
				if (offset >= 0 && offset <= 9) {
					stack.push(offset);
				} else {
					int top1 = stack.pop();
					int top2 = stack.pop();
					if (cc == '+') {
						stack.push(top2 + top1);
					} else if (cc == '-') {
						stack.push(top2 - top1);
					} else if (cc == '*') {
						stack.push(top2 * top1);
					} else if (cc == '/') {
						stack.push(top2 / top1);
					} else if (cc == '^') {
						stack.push((int) Math.pow(top2, top1));
					}
				}
			}

		}
		System.out.println(stack.pop());
	}

}
