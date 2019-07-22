package BinaryTree;

import java.util.Stack;

public class ITERATIVE_Inorder_PredSucc {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	static class Result {
		TreeNode pre = null;
		TreeNode succ = null;
	}

	// This is a functional problem. You have to complete this function.
	// It takes as input the root node of the given tree, an object of class Result
	// and a key.
	// It should set the pre and succ values of the object r for the given key, if
	// present, else should leave them null.
	public static void findPreSuc(TreeNode root, Result r, int key) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode prev = null;
		while (stack.size() > 0 || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			// work
			if (prev != null && root.val == key) {
				r.pre = prev;
			}
			if (prev != null && prev.val == key) {
				r.succ = root;
			}
			prev = root;
			root = root.right;
		}
	}

}
