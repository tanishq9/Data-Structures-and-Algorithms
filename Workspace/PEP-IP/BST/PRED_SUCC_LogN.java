package BST;

public class PRED_SUCC_LogN {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		public int hashCode() {
			return this.hashCode();
		}

		public boolean equals(Object obj) {
			TreeNode o = (TreeNode) obj;
			if (this.left == o.left && this.right == o.right) {
				return true;
			} else {
				return false;
			}
		}

	}

	static class Result {
		TreeNode pre = null;
		TreeNode succ = null;
	}

	public static void findPreSuc(TreeNode root, Result r, int key) {
		predecessor(root, key, r);
		successor(root, key, r);
	}

	static void predecessor(TreeNode root, int key, Result r) {
		if (root == null) {
			return;
		}
		if (root.val > key) {
			predecessor(root.left, key, r);
		} else if (root.val < key) {
			r.pre = root;
			predecessor(root.right, key, r);
		} else {
			// equal
			// find rmost of the left child
			if (root.left != null) {
				root = root.left;
				r.pre = root;
				while (root.right != null) {
					root = root.right;
					r.pre = root;
				}
			}
		}

	}

	static void successor(TreeNode root, int key, Result r) {
		if (root == null) {
			return;
		}
		if (root.val > key) {
			r.succ = root;
			successor(root.left, key, r);
		} else if (root.val < key) {
			successor(root.right, key, r);
		} else {
			// equal
			// find lmost of the right child
			if (root.right != null) {
				root = root.right;
				r.succ = root;
				while (root.left != null) {
					root = root.left;
					r.succ = root;
				}
			}
		}

	}
}
