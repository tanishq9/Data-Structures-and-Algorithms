package Stack;

import java.util.Stack;

public class minStack {

	static int minEle;
	static Stack<Integer> stack = new Stack<>();

	// Complete the below 3 functions only
	static int getMin() {
		if (stack.size() == 0) {
			return -1;
		}
		return minEle;
	}

	static int pop() {
		if (stack.size() == 0) {
			return -1;
		} else if (stack.peek() >= minEle) {
			return stack.pop();
		} else {
			int oldMin = minEle;
			minEle = 2 * minEle - stack.pop();
			return oldMin;
		}

	}

	static void push(int x) {
		if (stack.size() == 0) {
			stack.push(x);
			minEle = x;
		} else if (x >= minEle) {
			stack.push(x);
		} else {
			stack.push(2 * x - minEle);
			minEle = x;
		}

	}

}
