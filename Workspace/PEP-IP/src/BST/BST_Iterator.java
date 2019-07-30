package BST;

import java.util.Stack;

public class BST_Iterator {
	static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	static class BSTIterator {

		Stack<TreeNode> stack = null;

		public BSTIterator(TreeNode root) {
			stack = new Stack<>();
			this.fill(root);
		}

		private void fill(TreeNode root) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
		}

		/** @return the next smallest number */
		public int next() {
			TreeNode rv = stack.pop();
			if (rv.right != null) {
				this.fill(rv.right);
			}
			return rv.val;
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return stack.size() > 0;
		}
	}
}
