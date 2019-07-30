package BinaryTree;

public class reverseAlternateLevels2PointerApproach {
	void reverseAlternate(TreeNode node) {
		// Write your code here
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			return;
		}
		helper(node.left, node.right, 1);
	}

	void helper(TreeNode root1, TreeNode root2, int lvl) {
		if (root1 == null || root2 == null) {
			return;
		}
		if (lvl % 2 != 0) {
			int temp = root1.data;
			root1.data = root2.data;
			root2.data = temp;
		}
		helper(root1.left, root2.right, lvl + 1);
		helper(root1.right, root2.left, lvl + 1);
	}
}
