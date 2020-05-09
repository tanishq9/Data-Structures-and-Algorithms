package BinaryTree;

import java.util.ArrayList;

public class CONSTRUCT_In_From_Pre_Post {
	private class Node {
		int data;
		Node left;
		Node right;

		Node(int idata) {
			this.data = idata;
			this.left = null;
			this.right = null;
		}
	}

	Node constructPostIn(ArrayList<Integer> pre, ArrayList<Integer> post) {
		return helper(pre, post, 0, pre.size() - 1, 0, post.size() - 1);
	}

	Node helper(ArrayList<Integer> pre, ArrayList<Integer> post, int preStart, int preEnd, int postStart, int postEnd) {

		if (preStart > preEnd || postStart > postEnd) {
			return null;
		}

		if (preStart == preEnd) {
			return new Node(pre.get(preStart));
		}

		int lhs = 0; // left mei kitne bande hai
		for (int i = postStart; i <= postEnd; i++) {
			if (post.get(i) == pre.get(preStart + 1)) {
				break;
			} else {
				lhs++;
			}
		}
		Node newNode = new Node(pre.get(preStart));
		newNode.left = helper(pre, post, preStart + 1, preStart + lhs + 1, postStart, postStart + lhs);
		newNode.right = helper(pre, post, preStart + lhs + 2, preEnd, postStart + lhs + 1, postEnd - 1);
		return newNode;
	}
}
