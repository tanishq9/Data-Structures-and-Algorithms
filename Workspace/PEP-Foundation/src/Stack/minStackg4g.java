package Stack;

import java.util.Scanner;
import java.util.Stack;

public class minStackg4g {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T > 0) {
			int q = sc.nextInt();
			GfG g = new GfG();
			while (q > 0) {
				int qt = sc.nextInt();

				if (qt == 1) {
					int att = sc.nextInt();
					g.push(att);
					// System.out.println(att);
				} else if (qt == 2) {
					System.out.print(g.pop() + " ");
				} else if (qt == 3) {
					System.out.print(g.getMin() + " ");
				}

				q--;
			}
			System.out.println();
			T--;
		}

	}
}

class GfG {
	int minEle = -1;
	Stack<Integer> stack = new Stack<>();

	/* returns min element from stack */
	int getMin() {
		if (stack.size() > 0) {
			return minEle;
		} else {
			return -1;
		}
	}

	/* returns poped element from stack */
	int pop() {
		if (stack.size() > 0) {
			if (minEle > stack.peek()) {
				// We have to update the min
				// peek = 2*newmin-oldmin
				// oldmin = 2*newmin-peek
				// updating min element
				int ctop = stack.pop();
				int oldmin = minEle;
				minEle = 2 * minEle - ctop;
				return oldmin;
			} else {
				return stack.pop();
			}
		} else {
			return -1;
		}
	}

	/* push element x into the stack */
	void push(int x) {
		if (stack.size() == 0) {
			stack.push(x);
			minEle = x;
		} else if (x >= minEle) {
			stack.push(x);
		} else if (x < minEle) {
			// Push something smaller than original value
			// At any time when we pop , we will see if the value
			// of the peek is less then min or not
			stack.push(2 * x - minEle);
			minEle = x;
		}
	}
}
