package Stack;

import java.util.Stack;

public class minPattern {

	public static void main(String[] args) {
		String pattern = "ddidddid";
		System.out.println(min(pattern));
		String pattern2 = "dididddd";
		System.out.println(min(pattern2));
		String pattern3 = "idddiddd";
		System.out.println(min(pattern3));
		String pattern4 = "dddidddi";
		System.out.println(min(pattern4));
	}

	private static String min(String pattern) {
		String result = "";
		Stack<Integer> stack = new Stack<>();
		int counter = 1;
		for (int i = 0; i < pattern.length(); i++) {
			stack.push(counter);
			counter++;
			if (pattern.charAt(i) == 'i') {
				while (stack.size() > 0) {
					result += stack.pop();
				}
			}
		}
		stack.push(counter);
		while (stack.size() > 0) {
			result += stack.pop();
		}
		return result;
	}

}
