package BST;

public class LCA_BST {

	class TreeNode {
		int data;
		TreeNode left, right;

		TreeNode(int item) {
			data = item;
			left = right = null;
		}
	}

	class BST {
		TreeNode LCA(TreeNode root, int p, int q) {
			// Write your code here.
			if (p < root.data && q < root.data) {
				return LCA(root.left, p, q);
			} else if (p > root.data && q > root.data) {
				return LCA(root.right, p, q);
			} else {
				return root;
			}

		}

	}
}
