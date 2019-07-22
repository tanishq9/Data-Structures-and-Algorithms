package BinaryTree;

public class PairTemplate_Diameter {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		class DP {
			int height;
			int diameter;
		}

		public int diameterOfBinaryTree(TreeNode root) {
			if (root == null) {
				return 0;
			}
			return helper(root).diameter - 1; // diameter is terms of edges
		}

		private DP helper(TreeNode root) {
			if (root == null) {
				DP base = new DP();
				base.height = 0;
				base.diameter = 0;
				return base;
			}
			DP left = helper(root.left);
			DP right = helper(root.right);
			DP parent = new DP();
			parent.height = Math.max(left.height, right.height) + 1;
			parent.diameter = Math.max(Math.max(left.diameter, right.diameter), left.height + right.height + 1);
			return parent;
		}

	}
}
