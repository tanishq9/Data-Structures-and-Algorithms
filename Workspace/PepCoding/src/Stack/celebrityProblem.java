package Stack;

import java.util.Stack;

public class celebrityProblem {

	// The task is to complete this function
	int getId(int M[][], int n) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			stack.push(i);
		}
		while (stack.size() > 1) {
			int p1 = stack.pop();
			int p2 = stack.pop();
			// To discard one person based on 'knows'
			if (M[p1][p2] == 1) {
				// p1 cannot be the celebrity as he knows p2
				stack.push(p2);
			} else if (M[p1][p2] == 0) {
				// p2 cannot be the celebrity
				stack.push(p1);
			}
		}
		int cele = stack.pop();
		// Checking for cele now, because we have discarded for the others
		// example lets say stack has c and d at the top and knows(c,d) is 0
		// it means d is not a celebrity as celebrity has to be known by everyone
		// thus we have only c left on stack
		// now we explore the possibility of c being celebrity
		// by checking if everyone knows c and c doesn't know them all
		for (int i = 0; i < n; i++) {
			if (i != cele && (M[i][cele] == 0 || M[cele][i] == 1)) {
				return -1;
			}
		}
		return cele;
	}

}
