package Stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class longestValidParenthesis {

	static class Pair {
		int idx;
		char cc;

		Pair(int ix, char ic) {
			this.idx = ix;
			this.cc = ic;
		}
	}

	public static void main(String[] args) {
		String str = "";
		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(-1, ')')); // ),-1
		int maxLen = 0;
		for (int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			if (current == '(') {
				stack.push(new Pair(i, current));
			} else if (current == ')') {
				stack.pop();
				if (stack.size() != 0) {
					maxLen = Math.max(maxLen, i - stack.peek().idx);
				} else {
					stack.push(new Pair(i, current));
				}
			}
		}
		System.out.println(maxLen);
	}
}
