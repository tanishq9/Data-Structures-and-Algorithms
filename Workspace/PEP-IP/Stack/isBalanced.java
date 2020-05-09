package Stack;

import java.util.Stack;

public class isBalanced {
	public static void isbal(String s) {
		Stack<Character> stack = new Stack<>();
		boolean flag = true;
		for (char cc : s.toCharArray()) {
			if (cc == '{' || cc == '(' || cc == '[') {
				stack.push(cc);
			} else {
				if (stack.size() == 0) {
					flag = false;
					break;
				}
				if (cc == '}') {
					if (stack.peek() == '{') {
						stack.pop();
					} else {
						flag = false;
						break;
					}
				}
				if (cc == ')') {
					if (stack.peek() == '(') {
						stack.pop();
					} else {
						flag = false;
						break;
					}
				}
				if (cc == ']') {
					if (stack.peek() == '[') {
						stack.pop();
					} else {
						flag = false;
						break;
					}
				}
			}
		}
		if (flag == false) {
			System.out.println("not balanced");
		} else {
			System.out.println("balanced");
		}

	}
}
