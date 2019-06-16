package Stack;

import java.util.Stack;

public class sortStack {
	// This function return the sorted stack
	public static Stack<Integer> sortstack(Stack<Integer> input) {
		Stack<Integer> auxi = new Stack<>();
		while (input.size() > 0) {
			int top = input.pop();
			while (auxi.size() > 0 && auxi.peek() > top) {
				input.push(auxi.pop());
			}
			auxi.push(top);
		}
		return auxi;
	}
	/*We follow this algorithm.

	Create a temporary stack say tmpStack.
	While input stack is NOT empty do this:
	Pop an element from input stack call it temp
	while temporary stack is NOT empty and top of temporary stack is greater than temp,
	pop from temporary stack and push it to the input stack
	push temp in temporary stack
	The sorted numbers are in tmpStack*/

}
