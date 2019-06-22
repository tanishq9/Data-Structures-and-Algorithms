package Stack;

import java.util.Stack;

public class stackValidation {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		int idx = 0;
		for (int num : pushed) {
			stack.push(num);
			while (stack.size() > 0 && stack.peek() == popped[idx]) {
				stack.pop();
				idx++;
			}
		}
		while (idx < popped.length) {
			if (popped[idx] == stack.peek()) {
				stack.pop();
			}
			idx++;
		}
		return stack.size() == 0;
	}
}
