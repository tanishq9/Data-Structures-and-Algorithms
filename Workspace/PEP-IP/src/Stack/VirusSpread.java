package Stack;

import java.util.Scanner;
import java.util.Stack;

public class VirusSpread {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int[] res = new int[n];
		res[0] = 0;
		for (int i = 1; i < n; i++) {
			while (stack.size() > 0 && arr[stack.peek()] >= arr[i]) {
				stack.pop();
			}

			stack.push(i);
		}
	}

}
