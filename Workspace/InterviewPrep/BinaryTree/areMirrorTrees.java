package BinaryTree;

public class areMirrorTrees {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static boolean areMirror(TreeNode a, TreeNode b) {
		// write your code here.
		return helper(a, b);
	}

	static boolean helper(TreeNode r1, TreeNode r2) {
		if (r1 == null && r2 == null) {
			return true;
		}
		if (r1 == null || r2 == null) {
			return false;
		}
		if (r1.val != r2.val) {
			return false;
		}
		return helper(r1.left, r2.right) && helper(r1.right, r2.left);
	}

}
