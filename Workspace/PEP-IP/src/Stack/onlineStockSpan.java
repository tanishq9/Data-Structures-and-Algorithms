package Stack;

import java.util.Stack;

public class onlineStockSpan {
	class StockSpanner {

		Stack<Pair> stack;
		int index;

		public StockSpanner() {
			stack = new Stack<>();
			index = -1;
		}

		public int next(int price) {
			// Check if the element at the peek is more than current element
			// If not then keep popping
			while (stack.size() > 0 && stack.peek().val <= price) {
				stack.pop();
			}
			// Increment the index
			index++;
			// Store the answer and later return it
			int ans = stack.size() > 0 ? (index - stack.peek().idx) : index + 1;
			// Push the current element as it may be greater for other incoming elements
			stack.push(new Pair(price, index));
			return ans;
		}
	}

	class Pair {
		int val;
		int idx;

		Pair(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}
	}

}
