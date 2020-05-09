package Stack;

import java.util.Scanner;
import java.util.Stack;

public class evaluateTernary {

	public static String parseTernary(String expression) {
		int n = expression.length();
		Stack<String> stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			String cc = expression.charAt(i) + "";
			if (stack.size() > 0 && stack.peek().equals("?") && cc.equals("T")) {
				stack.pop();
				String t1 = stack.pop();
				String t2 = stack.pop();
				stack.push(t1);
			} else if (stack.size() > 0 && stack.peek().equals("?") && cc.equals("F")) {
				stack.pop();
				String t1 = stack.pop();
				String t2 = stack.pop();
				stack.push(t2);
			} else {
				if (!cc.equals(":")) {
					stack.push(cc);
				}
			}
		}
		return stack.peek();
	}

	// Don't make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(parseTernary(sc.next()));
	}

}
