package BST;

import java.util.Scanner;
import java.util.Stack;

public class PREORDER_BST_DoesPreOrderRepresentBST {
	// This is a functional problem. You have to complete this function.
	// It takes as input an integer array. It should return true if the array can
	// represent preorder traversal of a BST, else should return false.
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

	public static boolean preOrder(int[] pre) {
		int[] nge = nge(pre);
		return helper(pre, nge, 0, pre.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	static boolean helper(int[] pre, int[] nge, int s, int e, int min, int max) {
		if (s > e) {
			return true;
		}
		if (pre[s] <= min || pre[s] >= max) {
			return false;
		}
		int ngeIndex = nge[s];
		boolean lf = helper(pre, nge, s + 1, (ngeIndex - 1 <= e) ? ngeIndex - 1 : e, min, pre[s]);
		boolean rf = helper(pre, nge, ngeIndex, e, pre[s], max);
		return lf && rf;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		if (preOrder(arr)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

}
