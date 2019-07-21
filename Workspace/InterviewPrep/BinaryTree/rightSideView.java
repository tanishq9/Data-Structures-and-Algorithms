package BinaryTree;

import java.util.ArrayList;

public class rightSideView {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	static int maxH = -1;

	public static ArrayList<Integer> rightSideView(TreeNode root) {
		// write your code here.
		int curr = 0;
		ArrayList<Integer> res = new ArrayList<Integer>();
		helper(root, curr, res);
		return res;
	}

	static void helper(TreeNode root, int curr, ArrayList<Integer> res) {
		if (root == null) {
			return;
		}
		if (curr > maxH) {
			res.add(root.val);
			maxH = curr;
		}
		helper(root.right, curr + 1, res);
		helper(root.left, curr + 1, res);
	}
}
