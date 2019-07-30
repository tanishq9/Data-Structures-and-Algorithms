package BST;

public class insertIntoBST {
	class TreeNode {
		TreeNode left, right;
		int data;

		TreeNode(int d) {
			data = d;
			left = right = null;
		}

	}

	class BinaryTree {

		public TreeNode insertIntoBST(TreeNode root, int val) {
			if (root == null) {
				return new TreeNode(val);
			}
			if (root.data < val) {
				root.right = insertIntoBST(root.right, val);
			} else if (root.data > val) {
				root.left = insertIntoBST(root.left, val);
			}
			return root;
		}
	}
}
