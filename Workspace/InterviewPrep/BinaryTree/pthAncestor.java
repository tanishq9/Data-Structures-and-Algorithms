package BinaryTree;

import java.util.ArrayList;

public class pthAncestor {
	class TreeNode {
		int data;
		TreeNode left, right;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	class BinaryTree {
		public int PthAncestor(TreeNode root, int x, int y, int p, ArrayList<Integer> list) {
			ArrayList<Integer> path1 = getPath(root, x);
			ArrayList<Integer> path2 = getPath(root, y);
			int smaller = path1.size() > path2.size() ? path2.size() : path1.size();
			int lcaIndex = -1;
			// diverge logic
			for (int i = 0; i < smaller; i++) {
				if (path1.get(i) == path2.get(i)) {
					lcaIndex = i;
				} else {
					break;
				}
			}
			return path1.get(lcaIndex - p + 1);
		}

		private ArrayList<Integer> getPath(TreeNode root, int target) {
			if (root == null) {
				return null;
			}
			if (root.data == target) {
				ArrayList<Integer> br = new ArrayList<>();
				br.add(root.data);
				return br;
			}

			ArrayList<Integer> left = getPath(root.left, target);
			if (left != null) {
				left.add(0, root.data);
				return left;
			}
			ArrayList<Integer> right = getPath(root.right, target);
			if (right != null) {
				right.add(0, root.data);
				return right;
			}
			return null;
		}

	}

}
