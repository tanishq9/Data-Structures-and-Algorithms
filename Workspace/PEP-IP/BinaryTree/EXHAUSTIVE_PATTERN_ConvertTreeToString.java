package BinaryTree;

public class EXHAUSTIVE_PATTERN_ConvertTreeToString {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		// exhaustive pattern
		public String tree2str(TreeNode t) {
			if (t == null) {
				return "";
			}
			if (t.left != null && t.right != null) {
				return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
			} else if (t.left == null) {
				if (t.right != null) {
					return t.val + "()" + "(" + tree2str(t.right) + ")";
				}
			} else if (t.right == null) {
				return t.val + "(" + tree2str(t.left) + ")";
			}
			return t.val + "";
		}
	}
}
