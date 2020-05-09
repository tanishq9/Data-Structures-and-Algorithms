package BinaryTree;

import java.util.Stack;

public class ITERATIVE_InOrder_DiffInBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		public int getMinimumDifference(TreeNode root) {
			Stack<TreeNode> stack = new Stack<>();
			int min = Integer.MAX_VALUE;
			TreeNode pred = null;
			while (stack.size() > 0 || root != null) {
				while (root != null) {
					stack.push(root);
					root = root.left;
				}
				root = stack.pop();
				if (pred != null) {
					int diff = Math.abs(pred.val - root.val);
					if (diff < min) {
						min = diff;
					}
				}
				pred = root;
				root = root.right;
			}
			return min;
		}
	}
}
