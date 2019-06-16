package Stack;

import java.util.Stack;

public class maxRectangleAreaInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } };
		int[] ht = new int[matrix[0].length];
		int maxArea = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			ht = updateHT(matrix, ht, i);
			maxArea = Math.max(maxArea, maxRectArea(ht));
		}
		int a = (int) Math.ceil(2.5);
		System.out.println(a);
		System.out.println(maxArea);
	}

	public static int[] updateHT(int[][] matrix, int[] ht, int i) {
		for (int col = 0; col < matrix[0].length; col++) {
			if (matrix[i][col] == 0) {
				ht[col] = 0;
			} else {
				ht[col] += 1;
			}
		}
		return ht;
	}

	public static int maxRectArea(int[] ht) {
		// write your code here
		int n = ht.length;
		int[] lb = new int[n];
		int[] rb = new int[n];
		lb[0] = -1;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 0; i < n; i++) {
			while (stack.size() > 0 && ht[stack.peek()] >= ht[i]) {
				stack.pop();
			}
			lb[i] = stack.size() > 0 ? stack.peek() : -1;
			stack.push(i);
		}
		rb[n - 1] = n;
		stack = new Stack<>();
		stack.push(n - 1);
		for (int i = n - 1; i >= 0; i--) {
			while (stack.size() > 0 && ht[stack.peek()] >= ht[i]) {
				stack.pop();
			}
			rb[i] = stack.size() > 0 ? stack.peek() : n;
			stack.push(i);
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, (rb[i] - lb[i] - 1) * ht[i]);
		}
		return max;
	}

}
