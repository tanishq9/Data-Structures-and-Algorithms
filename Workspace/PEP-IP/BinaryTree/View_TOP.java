package BinaryTree;

import java.util.HashSet;
import java.util.LinkedList;

public class View_TOP {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = right = null;
		}
	}

	// This is a functional problem. You have to complete this function.
	// It takes as input the root node of the given tree. It should print the top
	// view of the tree.
	static class Pair {
		TreeNode node;
		int lvl;

		Pair(TreeNode n, int il) {
			this.node = n;
			this.lvl = il;
		}
	}

	public static void printTopView(TreeNode root) {
		// write your code here
		HashSet<Integer> set = new HashSet<>();
		LinkedList<Pair> q = new LinkedList<>();
		q.add(new Pair(root, 0));
		while (q.size() > 0) {
			Pair front = q.removeFirst();
			int currlvl = front.lvl;
			TreeNode currnode = front.node;

			if (!set.contains(currlvl)) {
				System.out.print(currnode.val + " ");
				set.add(currlvl);
			}

			if (currnode.left != null) {
				q.addLast(new Pair(currnode.left, currlvl - 1));
			}
			if (currnode.right != null) {
				q.addLast(new Pair(currnode.right, currlvl + 1));
			}
		}

	}
}
