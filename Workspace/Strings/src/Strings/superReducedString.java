package Strings;

import java.util.Stack;

public class superReducedString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "baabd";
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty()) {
				stack.push(s.charAt(i));
			} else {
				if (stack.peek() == s.charAt(i)) {
					stack.pop();
				} else {
					stack.push(s.charAt(i));
				}
			}
		}
		if (stack.isEmpty()) {
			System.out.println("Empty String");
		} else {
			while (!stack.isEmpty()) {
				sb.append(stack.peek());
				stack.pop();
			}
			sb.reverse();
			System.out.println(sb.toString());
		}
	}

}
