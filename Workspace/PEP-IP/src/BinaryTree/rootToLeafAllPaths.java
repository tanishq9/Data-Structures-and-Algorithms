package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class rootToLeafAllPaths {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// This is a functional problem. You have to complete this function.
	// It takes as input the root node of a binary tree. It should return
	// an arraylist containing all root-to-leaf paths in any order.
	public static ArrayList<String> binaryTreePaths(TreeNode root) {
		ArrayList<String> result = new ArrayList<String>();
		if (root == null) {
			return result;
		}
		helper(root, "", result);
		return result;
	}

	static void helper(TreeNode root, String path, List<String> res) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			res.add(path + root.val);
			return;
		}
		helper(root.left, path + root.val + "->", res);
		helper(root.right, path + root.val + "->", res);
	}

}
