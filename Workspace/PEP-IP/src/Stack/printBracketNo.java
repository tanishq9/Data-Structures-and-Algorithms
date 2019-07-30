package Stack;

import java.util.Stack;

public class printBracketNo {
	public static void printBracketsPos(String s) {
		Stack<Integer> stack = new Stack<>();
		int n = 0;
		for (int i = 0; i < s.length(); i++) {
			char cc = s.charAt(i);
			if (cc == '(') {
				++n;
				System.out.print(n + " ");
				stack.push(n);
			} else if (cc == ')') {
				System.out.print(stack.pop() + " ");
			}
		}
	}
}
