package BinaryTree;

import java.util.Stack;

public class ITERATIVE_Inorder_ValidateBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {

		public boolean isValidBST(TreeNode root) {
			Stack<TreeNode> stack = new Stack<>();
			TreeNode pred = null;
			while (stack.size() > 0 || root != null) {
				// go the extreme left
				while (root != null) {
					stack.push(root);
					root = root.left;
				}
				root = stack.pop();
				if (pred != null && root.val <= pred.val) {
					return false;
				}
				pred = root;
				root = root.right;
			}
			return true;
		}
	}
}
