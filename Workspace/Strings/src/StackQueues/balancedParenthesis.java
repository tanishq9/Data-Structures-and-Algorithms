package StackQueues;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class balancedParenthesis {

	static String isBalanced(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			} else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
				if (stack.isEmpty()) {
					return "NO";
				} else if (stack.peek() == '(' && s.charAt(i) == ')') {
					stack.pop();
				} else if (stack.peek() == '[' && s.charAt(i) == ']') {
					stack.pop();
				} else if (stack.peek() == '{' && s.charAt(i) == '}') {
					stack.pop();
				} else {
					return "NO";
				}
			}
		}
		if (stack.isEmpty()) {
			return "YES";
		}
		return "NO";
	}

	public static void main(String[] args) throws IOException {
		System.out.println(isBalanced("[{[}]"));
	}
}
