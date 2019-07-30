package BST;

class TreeNode {
	TreeNode left, right;
	int data;

	TreeNode(int d) {
		data = d;
		left = right = null;
	}

}

public class recoverBST_Recursive_PredecessorMethod {
	TreeNode n1 = null;
	TreeNode n2 = null;
	TreeNode pred = null;

	public void recoverTree(TreeNode node) {
		helper(node);
		if (n1 == null || n2 == null) {
			return;
		}
		int data = n1.data;
		n1.data = n2.data;
		n2.data = data;
	}

	void helper(TreeNode node) {
		if (node == null) {
			return;
		}
		helper(node.left);

		if (pred != null && n1 == null && pred.data > node.data) {
			n1 = pred; // assign first wrong
		}
		if (pred != null && n1 != null && pred.data > node.data) {
			n2 = node; // assign second wrong
		}
		// update the predecessor
		pred = node;

		helper(node.right);
	}
}
