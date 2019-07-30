package BST;

import java.util.Stack;

public class PREORDER_BST_PrintLeafNodes {
	static int[] nge(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int n = arr.length;
		int[] nge = new int[n];
		nge[n - 1] = n;
		stack.push(n - 1);
		for (int i = n - 2; i >= 0; i--) {
			while (stack.size() > 0 && arr[stack.peek()] <= arr[i]) {
				stack.pop();
			}
			nge[i] = stack.size() > 0 ? stack.peek() : n;
			stack.push(i);
		}
		return nge;
	}

	public static void print(int[] pre) {
		int[] ngei = nge(pre);
		helper(pre, ngei, 0, pre.length - 1);
	}

	static void helper(int[] pre, int[] nge, int s, int e) {
		if (s > e) {
			return;
		}
		if (s == e) {
			System.out.print(pre[s] + " ");
		}
		int ngeIndex = nge[s];
		helper(pre, nge, s + 1, (ngeIndex - 1) <= e ? ngeIndex - 1 : e);
		helper(pre, nge, ngeIndex, e);
	}
}
