package Stack;

import java.util.Scanner;
import java.util.Stack;

public class bracketReversals {

	public static int min_str_reversal(String s) {

		if (s.length() % 2 != 0) {
			return -1;
		}

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char cc = s.charAt(i);
			if (cc == '{') {
				stack.push(cc);
			} else if (cc == '}') {
				if (stack.size() > 0 && stack.peek() == '{') {
					stack.pop();
				} else {
					stack.push(cc);
				}
			}
		}
		int o = 0, c = 0;
		while (stack.size() > 0) {
			if (stack.peek() == '{') {
				o++;
			} else {
				c++;
			}
			stack.pop();
		}
		return (int) Math.ceil(o * 1.0 / 2.0) + (int) Math.ceil(c * 1.0 / 2.0);
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		System.out.println(min_str_reversal(s));

	}

}
