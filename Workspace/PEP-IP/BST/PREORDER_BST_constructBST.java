package BST;

import java.util.Scanner;
import java.util.Stack;

public class PREORDER_BST_constructBST {
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

	public static void postfrompre(int[] pre) {
		// write your code here.
		int[] ngei = nge(pre);
		printPost(pre, 0, pre.length - 1, ngei);
	}

	static void printPost(int[] pre, int preS, int preE, int[] nge) {
		// preS === preE toh chalta haina ,ek node toh print hoti hi hai
		// preS > preE invalid range
		// preS < preE range so keep on breaking the range
		if (preS > preE) {
			return;
		}
		int ngeIndex = nge[preS];
		printPost(pre, preS + 1, (ngeIndex - 1) <= preE ? ngeIndex - 1 : preE, nge);
		printPost(pre, ngeIndex, preE, nge);
		// Print in post order
		System.out.print(pre[preS] + " ");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] preorder = new int[N];
		for (int i = 0; i < preorder.length; i++) {
			preorder[i] = sc.nextInt();
		}

		postfrompre(preorder);

	}
}
