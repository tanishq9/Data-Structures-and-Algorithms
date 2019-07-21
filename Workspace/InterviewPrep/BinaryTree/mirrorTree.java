package BinaryTree;

public class mirrorTree {
	public static void mirror(TreeNode node) {
		// write your code here.
		helper(node);
	}

	static TreeNode helper(TreeNode node) {
		if (node == null) {
			return null;
		}
		TreeNode left = helper(node.left);
		TreeNode right = helper(node.right);
		node.left = right;
		node.right = left;
		return node;
	}
}
