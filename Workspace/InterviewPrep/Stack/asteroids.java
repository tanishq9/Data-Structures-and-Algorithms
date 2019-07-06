package Stack;

import java.util.Scanner;
import java.util.Stack;

public class asteroids {
	public static int[] asteroidCollision(int[] ast) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < ast.length; i++) {
			int curr = ast[i];
			if (stack.size() == 0) {
				stack.push(curr);
			} else {
				if (curr >= 0) {
					boolean isGreater = true;
					while (stack.size() > 0 && stack.peek() < 0) {
						int top = Math.abs(stack.peek());
						if (curr > top) {
							isGreater = true;
							stack.pop();
						} else if (curr == top) {
							break;
						} else if (curr < top) {
							isGreater = false;
							break;
						}
					}
					if (isGreater == true) {
						stack.push(curr);
					}
				} else if (curr < 0) {
					boolean isGreater = true;
					curr = Math.abs(curr);
					while (stack.size() > 0 && stack.peek() > 0) {
						int top = stack.peek();
						if (curr > top) {
							isGreater = true;
							stack.pop();
						} else if (curr == top) {
							break;
						} else if (curr < top) {
							isGreater = false;
							break;
						}
					}
					if (isGreater == true) {
						stack.push(curr * -1);
					}
				}
			}
		}
		int[] ans = new int[stack.size()];
		int i = stack.size() - 1;
		while (stack.size() > 0) {
			ans[i] = stack.pop();
			i--;
		}
		return ans;
	}

	// Dont make changes
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ast[] = new int[n];
		for (int i = 0; i < n; i++)
			ast[i] = sc.nextInt();
		int res[] = asteroidCollision(ast);
		for (int v : res) {
			System.out.println(v);
		}
	}

}
