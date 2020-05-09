package BinaryTree;

import java.util.LinkedList;

public class CONVERT_LL_to_BT {
	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	class LinkedListNode {
		int data;
		LinkedListNode next;

		LinkedListNode(int d) {
			data = d;
			next = null;
		}
	}

	class BinaryTree {

		public TreeNode convert(LinkedListNode head, TreeNode node) {
			TreeNode root = null;
			if (head != null) {
				root = new TreeNode(head.data);
			}
			head = head.next;
			LinkedList<TreeNode> q = new LinkedList<>();
			q.add(root);
			while (head != null) {
				TreeNode popped = q.removeFirst();
				if (head != null) {
					TreeNode lc = new TreeNode(head.data);
					popped.left = lc;
					q.addLast(lc);
					head = head.next;
				}
				if (head != null) {
					TreeNode rc = new TreeNode(head.data);
					popped.right = rc;
					q.addLast(rc);
					head = head.next;
				}
			}
			return root;
		}

	}
}
