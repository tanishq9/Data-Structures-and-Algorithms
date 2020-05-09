package BinaryTree;

public class CONVERT_BT_to_CDLL_EXHAUSTIVE_PATTERN {
	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			data = x;
		}
	}

	static class Pair {
		TreeNode h = null;
		TreeNode t = null;
	}

	public static TreeNode treeToDoublyList(TreeNode root) {
		// write your code here.
		Pair op = helper(root);
		op.h.left = op.t;
		op.t.right = op.h;
		return op.h;
	}

	static Pair helper(TreeNode root) {

		if (root == null) {
			return null;
		}

		if (root.left == null && root.right == null) {
			Pair base = new Pair();
			base.h = root;
			base.t = root;
			return base;
		} else if (root.left == null && root.right != null) {
			Pair rp = helper(root.right);
			root.right = rp.h;
			rp.h.left = root;

			root.left = rp.t;

			Pair mp = new Pair();
			mp.h = root; // my head is left pair's head
			mp.t = rp.t;

			return mp;
		} else if (root.right == null && root.left != null) {
			Pair lp = helper(root.left);
			lp.t.right = root;
			root.left = lp.t;

			root.right = lp.h;

			Pair mp = new Pair();
			mp.h = lp.h; // my head is left pair's head
			mp.t = root;

			return mp;
		} else if (root.left != null && root.right != null) {
			Pair lp = helper(root.left);
			Pair rp = helper(root.right);

			lp.t.right = root;
			root.left = lp.t;

			rp.h.left = root;
			root.right = rp.h;

			lp.h.left = rp.t;
			rp.t.right = lp.h;

			Pair mp = new Pair();
			mp.h = lp.h; // my head is left pair's head
			mp.t = rp.t; // my tail is right pair's tail
			return mp;
		}
		return null;
	}
}
