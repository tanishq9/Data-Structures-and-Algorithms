package BinaryTree;

import java.util.HashMap;

public class vertexCover {
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
		int f1 = 1 + count(root.left, map) + count(root.right, map);
		int f2 = 0;
		if (root.left != null) {
			f2 += 1 + count(root.left.left, map) + count(root.left.right, map);
		}
		if (root.right != null) {
			f2 += 1 + count(root.right.left, map) + count(root.right.right, map);
		}
		int f = Math.min(f1, f2);
		map.put(root, f);
		return f;
	}
}
