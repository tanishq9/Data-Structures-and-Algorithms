package BinaryTree;

public class isFoldable {
	public boolean isFoldable(TreeNode root) {
		// Write your code here
		return isSymmetric(root.left, root.right);
	}

	boolean isSymmetric(TreeNode r1, TreeNode r2) {
		if (r1 == null && r2 != null) {
			return false;
		}
		if (r1 != null && r2 == null) {
			return false;
		}
		if (r1 == null && r2 == null) {
			return true;
		}
		boolean l1r2 = isSymmetric(r1.left, r2.right);
		boolean r1l2 = isSymmetric(r1.right, r2.left);
		if (l1r2 == false || r1l2 == false) {
			return false;
		}
		return true;
	}
}
