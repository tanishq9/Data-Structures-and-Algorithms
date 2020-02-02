package Stack;

import java.util.Stack;

public class minStack {

	static class mStack {
		private Stack<Integer> stack = null;
		int min;

		mStack() {
			this.stack = new Stack<>();
		}

		void push(int val) {
			if (stack.size() == 0) {
				stack.push(val);
				min = val;
			} else if (min <= val) {
				stack.push(val);
			} else {
				stack.push(2 * val - min);
				min = val;
			}
		}

		void pop() {
			if (stack.peek() >= min) {
				stack.pop();
			} else {
				int ctop = stack.peek();
				stack.pop();
				min = 2 * min - ctop;
			}
		}

		int top() {
			if (stack.peek() >= min) {
				return stack.peek();
			} else {
				return min;
			}
		}

		int getMin() {
			return min;
		}
		int size() {
			return stack.size();
		}
	}

	public static void main(String[] args) {
		mStack stack = new mStack();
		stack.push(5);
		stack.push(4);
		stack.push(6);
		stack.push(1);
		stack.push(3);
		while(stack.size()>0) {
			System.out.println(stack.getMin());
			stack.pop();
		}
		
	}

}
