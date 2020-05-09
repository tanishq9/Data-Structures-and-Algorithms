package Queue;

import java.util.Stack;

public class QueueUsing2Stacks {
	class MyQueue {

		/** Initialize your data structure here. */
		Stack<Integer> s1 = null;
		Stack<Integer> s2 = null;

		public MyQueue() {
			s1 = new Stack<>(); // For main processing
			s2 = new Stack<>(); // For temporary transfer from stack 1
		}

		/** Push element x to the back of queue. */
		public void push(int x) {
			s1.push(x);
		}

		/** Removes the element from in front of queue and returns that element. */
		public int pop() {
			if (s2.size() == 0) {
				while (s1.size() > 0) {
					s2.push(s1.pop());
				}
			}
			return s2.pop();
		}

		/** Get the front element. */
		public int peek() {
			// Amortized O(1), otherwise every time we have to pop n items but now not every
			// time
			if (s2.size() > 0) {
				return s2.peek();
			} else {
				while (s1.size() > 0) {
					s2.push(s1.pop());
				}
			}
			return s2.peek();
		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
			return s1.size() == 0 && s2.size() == 0;
		}
	}

	/**
	 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
	 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
	 * obj.peek(); boolean param_4 = obj.empty();
	 */
}
