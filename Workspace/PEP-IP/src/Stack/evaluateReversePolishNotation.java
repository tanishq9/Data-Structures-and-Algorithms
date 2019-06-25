package Stack;

import java.util.Stack;

public class evaluateReversePolishNotation {
	public static int evalRPN(String[] S) {
		// Write your code here
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < S.length; i++) {
			String s = S[i];
			// length > 1 for -ve numbers and length = 1 & digit for single digit positive
			// numbers
			if (s.length() > 1 || (s.length() == 1 && Character.isDigit(s.charAt(0)))) {
				stack.push(Integer.valueOf(s));
			} else {
				int p = stack.pop();
				int q = stack.pop();
				if (s.equals("*")) {
					stack.push(p * q);
				} else if (s.equals("/")) {
					stack.push(q / p);
				} else if (s.equals("+")) {
					stack.push(q + p);
				} else {
					stack.push(q - p);
				}
			}
		}
		return stack.pop();
	}

}
