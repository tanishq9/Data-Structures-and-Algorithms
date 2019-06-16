package Stack;

import java.util.Scanner;
import java.util.Stack;

public class stackGame {
	public static int calculatePoints(String[] ops) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < ops.length; i++) {
			String cs = ops[i];
			try {
				int offset = Integer.valueOf(cs);
				stack.push(offset);
				continue;
			} catch (Exception e) {
			}
			if (cs.equals("C")) {
				stack.pop();
			} else if (cs.equals("D")) {
				stack.push(2 * stack.peek());
			} else if (cs.equals("+")) {
				int t1 = stack.pop();
				int t2 = stack.pop();
				int nval = t1 + t2;
				stack.push(t2);
				stack.push(t1);
				stack.push(nval);
			}
		}

		int sum = 0;
		while (stack.size() > 0) {
			sum += stack.pop();
		}
		return sum;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] S = new String[n];
		for (int i = 0; i < n; i++) {
			S[i] = sc.next();
		}
		System.out.println(calculatePoints(S));
	}

}
