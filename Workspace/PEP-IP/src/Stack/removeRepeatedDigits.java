package Stack;

import java.util.Stack;

public class removeRepeatedDigits {
	static long removeRep(long n) {
		Stack<Long> stack = new Stack<>();
		long res = 0;
		while (n > 0) {
			long rem = n % 10;
			if (stack.size() == 0) {
				stack.push(rem);
			} else {
				while (stack.size() > 0 && rem == stack.peek()) {
					stack.pop();
				}
				stack.push(rem);
			}
			n = n / 10;
		}

		while (stack.size() > 0) {
			res = res * 10 + stack.pop();
		}

		return res;
	}

}
