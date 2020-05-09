package Stack;

import java.util.Stack;

public class scoreOfString {

	public static int scoreOfParentheses(String s) {
		Stack<String> stack = new Stack<>();
		int ans = 0;
		// Solving for the whole string using stack
		for (char cc : s.toCharArray()) {
			// If opening bracket, just push it.
			if (cc == '(') {
				stack.push(cc + "");
			} else {
				// If closing bracket, then depending upon the 'type' compute sum between
				// braces,
				// and push the new result to the stack
				if (cc == ')') {
					int sum = 0;
					while (stack.size() > 0 && !stack.peek().equals("(")) {
						sum += (Integer.valueOf(stack.pop()));
					}
					stack.pop(); // remove the opening bracket now
					if (sum == 0) {
						stack.push("1");
					} else {
						stack.push(String.valueOf(2 * sum));
					}
				}
			}
		}
		// Since we may have many expressions : Eg -> ()()(())
		while (stack.size() > 0) {
			ans += Integer.valueOf(stack.pop());
		}
		return ans;
	}

	public static void main(String[] args) {
		String str = "(()(()))";
		System.out.println(scoreOfParentheses(str));
	}
}
