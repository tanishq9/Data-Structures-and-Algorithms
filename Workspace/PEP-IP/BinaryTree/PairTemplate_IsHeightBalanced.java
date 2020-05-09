package BinaryTree;

public class PairTemplate_IsHeightBalanced {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		class BP {
			int height;
			boolean isbalanced;
		}

		public boolean isBalanced(TreeNode root) {
			return helper(root).isbalanced;
		}

		BP helper(TreeNode root) {
			if (root == null) {
				BP base = new BP();
				base.height = 0;
				base.isbalanced = true;
				return base;
			}
			BP left = helper(root.left);
			BP right = helper(root.right);
			BP parent = new BP();
			parent.height = Math.max(left.height, right.height) + 1;
			parent.isbalanced = (left.isbalanced == true && right.isbalanced == true
					&& Math.abs(left.height - right.height) <= 1);
			return parent;
		}

	}
}
