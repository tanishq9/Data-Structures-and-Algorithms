package BST;

public class recoverBST_Recursive_Oh_space {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	TreeNode x = null, y = null, pred = null;

	public void recoverTree(TreeNode root) {
		recover(root);
		swap(x, y);
	}

	void swap(TreeNode x, TreeNode y) {
		int temp = x.val;
		x.val = y.val;
		y.val = temp;
	}

	void recover(TreeNode root) {
		if (root == null) {
			return;
		}
		recover(root.left);
		// Work
		if (pred != null && pred.val > root.val) {
			if (x == null) { // assign peak
				x = pred;
			}
			if (x != null) { // assign valley
				y = root;
			}
		}
		pred = root;
		recover(root.right);
	}

}
