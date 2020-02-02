package Crio_Launch_HackerRank_Java;

import java.util.Scanner;
import java.util.Stack;

public class Java_Stack {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String input = sc.next();
			// Complete the code
			boolean flag = true;
			Stack<Character> stack = new Stack<>();
			for (char cc : input.toCharArray()) {
				// For Closed Braces
				if (cc == ']' || cc == ')' || cc == '}') {
					// Check size of stack
					if (stack.isEmpty()) {
						flag = false;
						break;
					}
					// Improper Match
					if (cc == ']' && stack.peek() == '[') {
						stack.pop();
						continue;
					} else if (cc == ')' && stack.peek() == '(') {
						stack.pop();
						continue;
					} else if (cc == '}' && stack.peek() == '{') {
						stack.pop();
						continue;
					} else {
						flag = false;
						break;
					}
				} else {
					// For Open Braces
					stack.push(cc);
				}
			}
			if (stack.size() != 0) {
				flag = false;
			}
			if (flag == false) {
				System.out.println("false");
			} else {
				System.out.println("true");
			}
		}
	}
}
