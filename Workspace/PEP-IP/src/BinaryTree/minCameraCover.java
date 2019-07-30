package BinaryTree;

import java.util.HashMap;

// INCORRECT CODE : SOLVE ON LEETCODE TO SEE THE RIGHT SOLUTION
public class minCameraCover {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}

		// No need to override hashCode and equals

		public boolean equals(Object obj) {
			TreeNode o = (TreeNode) obj;
			if (this.left == o.left && this.right == o.right) {
				return true;
			} else {
				return false;
			}
		}

	}

	// This is a functional problem. You have to complete this function.
	// It takes as input the root of the given tree. It should return the minimum
	// number of cameras required.
	public static int minCameraCover(TreeNode root) {
		// write your code here
		HashMap<TreeNode, Integer> map = new HashMap<>();
		return count(root, map);
	}

	static int count(TreeNode root, HashMap<TreeNode, Integer> map) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 0;
		}
		if (map.containsKey(root)) {
			return map.get(root);
		}
		// +1 isliye kyuki ek khudka bhi toh lagega

		// Parent pe lagado
		int f1 = 0;
		if (root != null) {
			f1 += 1;
		}
		if (root.left != null) {
			f1 += count(root.left.left, map) + count(root.left.right, map);
		}
		if (root.right != null) {
			f1 += count(root.right.left, map) + count(root.right.right, map);
		}
		// Left child pe lagado
		int f2 = 0;
		if (root.left != null) {
			f2 += 1;
		}
		if (root.left != null && root.left.left != null) {
			f2 += count(root.left.left.left, map) + count(root.left.left.right, map);
		}
		if (root.left != null && root.left.right != null) {
			f2 += count(root.left.right.left, map) + count(root.left.right.right, map);
		}

		// Right child pe lagado
		int f3 = 0;
		if (root.right != null) {
			f3 += 1;
		}
		if (root.right != null && root.right.left != null) {
			f3 += count(root.right.left.left, map) + count(root.right.left.right, map);
		}
		if (root.right != null && root.right.right != null) {
			f3 += count(root.right.right.left, map) + count(root.right.right.right, map);
		}
		int f = Math.min(f1, Math.min(f2, f3));
		map.put(root, f);
		return f;
	}
}
