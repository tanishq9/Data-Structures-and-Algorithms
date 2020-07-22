package StackQueues;

import java.util.Stack;

public class redudantBraces {

	public static void main(String[] args) {
		String exp = "(a+(b+c))";
		boolean redudant = false;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < exp.length(); i++) {
			char cc = exp.charAt(i);
			int offset = cc - '0';
			if (offset >= 0 && offset <= 9) {
				// do nothing
			} else if (cc == '(') {
				stack.push('(');
			} else if (cc == ')') {
				int bt = 0;
				while (stack.size() > 0 && stack.peek() != '(') {
					stack.pop();
					bt++;
				}
				stack.pop();
				if (bt == 0) {
					redudant = true;
				}
			} else {
				if (cc == '+') {
					stack.push('+');
				} else if (cc == '-') {
					stack.push('-');
				} else if (cc == '*') {
					stack.push('*');
				} else if (cc == '/') {
					stack.push('/');
				} else if (cc == '^') {
					stack.push('^');
				}
			}
		}
		System.out.println(redudant);
	}

}
