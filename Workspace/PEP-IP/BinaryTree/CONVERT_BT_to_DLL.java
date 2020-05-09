package BinaryTree;

public class CONVERT_BT_to_DLL {
	class Pair {
		TreeNode h;
		TreeNode t;
	}

	TreeNode head;

	public TreeNode BT2DLL(TreeNode root) {
		return helper(root).h;
	}

	Pair helper(TreeNode root) {
		if (root == null) {
			Pair base = new Pair();
			base.h = null;
			base.t = null;
			return base;
		}
		if (root.left == null && root.right == null) {
			Pair base = new Pair();
			base.h = root;
			base.t = root;
			return base;
		}
		Pair lp = helper(root.left);
		Pair rp = helper(root.right);

		if (lp != null) {
			lp.t.right = root;
			root.left = lp.t;
		}

		if (rp != null) {
			rp.h.left = root;
			root.right = rp.h;
		}

		Pair mp = new Pair();
		mp.h = lp.h; // my head is left pair's head
		mp.t = rp.t; // my tail is right pair's tail
		return mp;
	}

}
