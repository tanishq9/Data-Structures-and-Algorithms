package Stack;

import java.util.Stack;

public class sortStack {
	public Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> auxi = new Stack<>();
		while (s.size() > 0) {
			int top = s.pop();
			while (auxi.size() > 0 && top < auxi.peek()) {
				s.push(auxi.pop());
			}
			auxi.push(top);
		}
		return auxi;
	}
}
