package Stack;

import java.util.Stack;

public class removeKdigitsToMakeSmallest {
	public static String removeMakeSmallest(String str, int k) {
		Stack<Integer> stack = new Stack<>();
		// corner case
		if (k == str.length())
			return "0";

		for (int i = 0; i < str.length(); i++) {
			while (stack.size() > 0 && k > 0 && stack.peek() > (str.charAt(i) - '0')) {
				stack.pop();
				k--;
			}
			stack.push(str.charAt(i) - '0');
		}
		while (k-- > 0) {
			stack.pop();
		}
		StringBuilder sb = new StringBuilder();
		while (stack.size() > 0) {
			sb.append(stack.pop() + "");
		}
		sb.reverse();
		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

}
